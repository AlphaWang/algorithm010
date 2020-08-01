# Week 08 学习笔记


## 知识点


- 位运算
  - 位运算符：或`|`  与`&` 取反 `~` 异或 `^` 
  - 异或的特点
    - `x ^ 0 = x`
    - `x ^ 1s = ~x` (1s 表示全1)
    - `x ^ ~x = 1s`
    - `x ^ x = 0`
    - `c = a ^ b` --> `a ^ c = b`, `b ^ c = a`
    - `a ^ b ^ c` = `a ^ (b ^ c)` = `(a ^ b) ^ c`
    
  - 指定位置的位运算
    - 将右边n位清零：`x & (~0 << n)`
    - 获取第n位：`(x >> n) & 1`
    - 获取第n位的幂值：`x & (1 << n)`
    - 将第n位置为1：`x | (1 << n)`
    - 将第n位置为0：`x & (~(1 << n))`
    - 将最高位至第n位置为0：`x & ((1 << n) - 1)`

  - 实战要点
    - 判断奇偶：  
       `x % 2 == 1` --> `(x & 1) == 1`  
       `x % 2 == 0` --> `(x & 1) == 0`
    - 除2：  
       `x / 2` --> `x >> 1`   
       `min = (left + right) / 2` --> `mid = (left + right) >> 1`
    - 清零最低位的1  
       `x & (x-1)`  
    - 得到最低位的1  
       `x & -x`
    - `x & ~x => 0`

- Bloom Filter
  - 思路：用一个很长的二进制向量，以及一系列随机映射函数。
  - 场景：检索一个元素是否在集合中。
  
- LRU
  - 思路：Hash Table + Double LinkedList  
  - 复杂度
    - 查询：O(1)
    - 修改：O(1)
  
- 排序 
  - 分类
    - 比较类排序：通过比较来决定元素的相对次序，时间复杂度不能突破 O(NlogN)
    - 非比较类排序：不通过比较来决定相对次序，可突破 O(NlogN)
    
  - 比较类排序
    - O(N^2)
        - 选择排序：  
        每次找最小值，放到待排序数组的起始位置。
        - 插入排序：  
        从前到后逐步构建，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置插入。
        - 冒泡排序：  
        嵌套循环，每次比较并交换相邻元素。
        
    - O(Nlog)  
        - 快速排序：  
        取标杆 pivot，将小元素放pivot左侧，大元素放右侧。再依次对左右子数组继续快排。
            > 先调配出左右子数组，然后对子数组分别排序。
            ```
            int pivotIndex = partition(array, start, end); // 重要！
            quickSort(array, start, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
            ```  
        - 归并排序：  
        分解成两个长度为 n/2 的子序列；对子序列分别采用归并排序；将排序好的两个子序列合并。
            > 先排序左右子数组，再合并。
            ```
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);  // 重要！
            ``` 
         - 堆排序：  
         数组元素一次建立小顶堆，依次取堆顶元素，并删除。  
         插入 O(logN)，取堆顶 O(1)
         
  - 非比较类排序
    - O(N)
        - 计数排序：  
            - 要求元素是整数；  
            - 先用额外空间计数，再依次把计数大于1的填充回数组。
        
        - 桶排序
            - 假设数据均匀分布。
            - 将数据分到有限数量的桶里，每个桶再分别排序。
        
        - 基数排序  
            - 先按低位排序、收集；再按高位排序、收集；依次类推知道最高位。
            - 扩展：先按低优先级的属性排序，再按高优先级排序。
  
  - 对比 & 动画
    - https://www.cnblogs.com/onepixel/p/7674659.html   
    - https://www.bilibili.com/video/av25136272  
    - https://www.bilibili.com/video/av63851336


## 作业

- [x] 191: Number of 1 bits `***` `E`
https://leetcode.com/problems/number-of-1-bits/
  > 1: 枚举所有位数：不断右移 %2， 余数==1则count++ (循环32次，右移 == `/2`)
  > 2: 枚举所有位数：& mask(初始值=1), mask每次左移一位
  > 3: x = x & (x-1) 清零最低位的1

- [x] 231: Power of Two `***` `E`  
https://leetcode.com/problems/power-of-two/    
  > 1: 不断 mod 2, 测试是否能被2整除 --> 即不断右移一位，测试最后一位   
  > 2: 数学求 log2     
  > 3: n & (n-1) == 0, 去除最后一个 1 。利用特点：最前面是1，后面全0：
  > 4: n & (-n) == n, 获取最后一个1  

- [x] 190: 颠倒二进制位 `***` `E`
https://leetcode.com/problems/reverse-bits/
  > 1: 转换成字符串，再颠倒
  > 2: n >> 1，依次处理最低位
  >    https://leetcode-cn.com/problems/reverse-bits/solution/zhi-qi-ran-zhi-qi-suo-yi-ran-wei-yun-suan-jie-fa-x/
  > 

- [x] 1122: 数组的相对排序 `*****` `E`
https://leetcode.com/problems/relative-sort-array/
  > 1: 计数排序
  >    先计算arr1每个元素的个数，再按照arr2的顺序重置arr1；再遍历counter处理!arr2元素
  >    注意，重置数据的过程中 while(counter[i]-- > 0) ，清空counter数组
 
- [x] 242: 有效的字母异位词 `*****` `E`   
https://leetcode.com/problems/valid-anagram/   
  > 1: 先排序，再比较   
  > 2: Map 计数，比较Map是否相同  
  > 3: int[26] 计数   
 
- [x] 56: 合并区间 `*****` `M`
https://leetcode.com/problems/merge-intervals/
  > 1: 按首位排序，依次比较prev vs. curr   
 
- [x] 493: 翻转对 `***` `H` 
https://leetcode.com/problems/reverse-pairs/
  > 1: 嵌套循环 O(N^2)
  > 2: merge-sort O(NlogN)，归并的过程中做统计

 
## 预习
















