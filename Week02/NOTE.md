# Week02 学习笔记

## 知识点
- 哈希表
  - 散列函数、碰撞
  - 工程实践：电话号码簿，用户信息表，缓存，键值对存储。

- 集合

- 树
  - LinkedList是特殊的树
  - 树是特殊的图
  - 树的遍历：前序，中序，后序
  
- 二叉搜索树
  - 左子树 **所有** 节点值都小于根节点
  - 右子树 **所有** 节点值都大于根节点
  - 中序遍历：升序排列
  
- 图

## 作业
- [x] 242: 有效的字母异位词 `*****` `E`  
https://leetcode.com/problems/valid-anagram/ 
  > 1: 先排序，再比较   
  > 2: Map 计数，比较Map是否相同  
  > 3: int[26] 计数     

- [x] 1: Two Sum `***` `E`  
https://leetcode.com/problems/two-sum/  
  > 1: 暴力解法：两重遍历   
  > 2: 哈希：遍历一遍，记录 Map<期望匹配值，index>；或记录 Map<元素值, index>   

- [x] 589: N叉树前序遍历 `*****` `E`  
https://leetcode.com/problems/n-ary-tree-preorder-traversal/  
  > 1: 递归  
  > 2: 栈：倒序遍历子节点，入栈   

- [x] 49: 字母异位词分组 `*****` `M`  
https://leetcode.com/problems/group-anagrams/  
  > Map: key - 异位词hash, value - 字符串列表  
  > 哈希算法：1. 排序后的字符串；2. int[26] ；  

- [x] 94: 二叉树中序遍历 `*****` `M`  
https://leetcode.com/problems/binary-tree-inorder-traversal/
  > 1: 递归  
  > 2: 迭代，使用栈  
  > 3: 优化栈，保存状态：更通用   

- [x] 144: 二叉树前序遍历 `****` `M`  
https://leetcode.com/problems/binary-tree-preorder-traversal/  
  > 1: 递归  
  > 2: 迭代，使用栈   
  > 3: 优化栈，保存状态：更通用   

- [x] 429: N叉树层序遍历 `*****` `M`  
https://leetcode.com/problems/n-ary-tree-level-order-traversal/  
  > 1: BFS 基于队列       
  > 2: DFS    
  > 3: BFS 基于List保存上一层数据 *****   

- [x] 263: 丑数 `***` `E`   
https://leetcode.com/problems/ugly-number/  
  > 1: 递归，依次尝试除以 [2,3,5]    
  > 2: 迭代，如能整除 [2,3,5]，则除   

- [x] 264: 丑数2 `*****` `M`    
https://leetcode.com/problems/ugly-number-ii/   
  > 1：暴力，循环判断isUgly      
  > 2: 堆，将计算得出的丑数放入Heap，再从小到大取出依次乘以 [2,3,5]  
  > 3: DP 三指针，表示待与 [2,3,5] 相乘的数       

- [x] 347: 前K个高频元素 `*****` `M`   
https://leetcode.com/problems/top-k-frequent-elements/   
  > Map: num - count    
  > 1: 对Map进行排序，取前K       
  > 2: 将Map元素导入堆中    
  > 3: 将Map元素进行桶排序 （只适用于非负数元素）   
  > 4: 快排思想 （?）  
  > 5: 不用Map，而将 num+count作为对象排序。--> 为什么会更快？   

## 预习

- [x] 70: 爬楼梯 `****` `E`   
https://leetcode.com/problems/climbing-stairs/  
  > 找最近重复子问题，数学归纳法。    
  > 如何走到第n级：从n-1走过来 + 从n-2级走过来。   
  > 1: 斐波那契数列，递归 f(n) = f(n-1) + f(n-2)。   
  > 2: 优化：缓存，保存a[i]；或直接只保存最后三个数。  
  > 3: 迭代：3~n      
  > 4: DP:  
  >    状态： dp[n] 登到第n级台阶的方法数     
  >    状态转移方程： dp[n] = dp[n-1] + dp[n-2]      

- [x] 22: generate-parentheses  
https://leetcode.com/problems/generate-parentheses/   
  > 1: 数学归纳法：n=1, 2, ...   
  > 2: 递归：构造2*n长度的数组，元素分别填入左右括号，validate     
  > 3: 改进2，剪枝：        
       a) 局部不合法，不再递归；  
       b) 保存leftUsed / rightUsed     


- [x] 50: powx-n   
https://leetcode.com/problems/powx-n/   
  > 1: 调用库函数   
  > 2: 暴力：一层循环，逐个相乘    
  > 3: 分治：如果是偶数个 = y * y; 如果是奇数个 = y * y * x. (y = x的n/2方)    
   ``` 
    r = power(a, n / 2);
   ```
  > 4: 迭代：
   ```   
  int res = 1, tmp = a;
  while(n) {
    if (n & 1 ) res *= tmp;  
    n >>= 1;
    tmp *= tmp;
  }    
  return res;
   ```

- [x] 78: 子集 `*****` `M`  
https://leetcode.com/problems/subsets/  
  > 1: 对 nums 依次删除元素，依靠Set去重  
  > 2: 从空数组开始，依次考虑原数组每个元素，往已有的结果中添加    
  > 3: 回溯 ？   
  > 4: 位运算？    

- [x] 51: N 皇后 `**` `H`   
https://leetcode.com/problems/n-queens/  
  > 1: 暴力    
  > 2: 剪枝：标记 行col[col]，撇pie[row+col]，捺na[row-col]     
  > 3: 位运算：判重记录二进制 col, pie, na (???)    
