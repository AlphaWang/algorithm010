# Week 03 学习笔记

## 知识点

- 泛型递归
  - 树的面试题解法一般都是递归：节点定义、重复性（自相似性）

  - 递归 - 循环：通过函数体来进行的循环。

  - 代码模板

    ```
    public void recur(int level, int param) {
      // terminator
      if (level > MAX) {
        return;
      }
      
      //process current level
      process(level, param);
      
      //dirll down
      recur(level + 1, param);
      
      //restore current status
    
    }
    ```

  - 思维要点：

    1. 不要人肉进行递归；
    2. 找到最近最简方法，将其拆解成重复子问题；
    3. 数学归纳法思维；

  - 题目：爬楼梯，括号生成

- 分治

  - 代码模板

    ```
    public void divideConquer(problem, params) {
      // terminator
      if problem is None {
        printResult();
        return;
      }
      
      // prepare data
      data = prepareData(problem)
      subproblems = splitProblem(problem, data);
      
      // conquer subproblems
      subResult1 = divideConquer(subproblems[0], params);
      subResult2 = divideConquer(subproblems[1], params);
      ...
      
      // process and generate the final result
      result = processResult(subResult1, subResult2, ...);
      
      // revert the current level states
      
    }
    ```

- 回溯

  - 采用试错的思想，尝试分步去解决一个问题。当发现分步答案不正确，则取消上一步的计算，尝试其他可能的解。
  - 时间复杂度：指数。
  - 题目：PowX-N，子集，众数，N皇后



## 作业

- [x] 17: 电话号码字母组合 `*****` `M`
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
  
  > 1: 回溯：level = 当前处理第几个数字



- [x] : 全排列 `*****` `M` //TODO
https://leetcode.com/problems/permutations/
  > 1: 递归回溯
  > for i in 0~len, path.add(nums[i])
  > dfs(depth + 1)
  > 状态变量hui                                 
  >
  >    - depth: 递归到第几层 
  >    - path: 已经选择了哪些数 (Stack)
  >    - used: boolean[]，已经选择的数
  
- [x] 47: 全排列2 `*****` `M` 46
https://leetcode.com/problems/permutations-ii/

- [x] 50: powx-n   
https://leetcode.com/problems/powx-n/   
  > 1: 调用库函数   
  > 2: 暴力：一层循环，逐个相乘    
  > 3: 分治：如果是偶数个 = y * y; 如果是奇数个 = y * y * x. (y = x的n/2方)    
  >  r = power(a, n / 2);
  > 4: 迭代：
  >
  > ```
  > int res = 1, tmp = a;
  > while(n) {
  >   if (n & 1 ) res *= tmp;  
  >   n >>= 1;
  >   tmp *= tmp;
  > }    
  > return res;
  > ```

- [x] 51: N 皇后 `**` `H`   
https://leetcode.com/problems/n-queens/  
  > 1: 暴力    
  > 2: 剪枝：标记 行col[col]，撇pie[row+col]，捺na[row-col]     
  > 3: 位运算：判重记录二进制 col, pie, na (???)    

- [x] 77: 组合 `*****` `M`
https://leetcode.com/problems/combinations/
  > 1: 递归回溯: 
  > for i in level~n, list.add(i) 
  > dfs(i + 1)

- [x] 78: 子集 `*****` `M`  
https://leetcode.com/problems/subsets/  
  > 1: 对 nums 依次删除元素，依靠Set去重  
  > 2: 从空数组开始，依次考虑原数组每个元素，往已有的结果中添加  
  > 3: DFS，类似创建括号对  
  > 3: 回溯   
  > 4: 位运算？   

- [x] 105: 从前序与中序遍历序列构造二叉树 `*****` `M` //TODO
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
  > 1: 递归 
  > preStart: 根节点，遍历preorder
  > inStart / inEnd: 中序遍历数组的有效位

- [x] 169: 众数
https://leetcode.com/problems/majority-element
  > 1: 暴力: 遍历元素，再遍历求次数
  > 2: Map: 遍历元素，放入map计数
  > 3: 排序: 排序后遍历。--> 优化：排序后直接取最中间元素
  > 4: 分治: 分别求左右众数，当 left == right --> left; 当left count > right count --> left

- [x] 236: 二叉树的最近公共祖先 `****` `M`  
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
  > 1: 向上找 Path，找到两条 Path 的交汇点。
  > 2: 递归 findPorQ(), 如果左右子树返回值都 != null，则当前节点是祖先。否则继续查找返回值 != null 的子树。 



## 预习 

