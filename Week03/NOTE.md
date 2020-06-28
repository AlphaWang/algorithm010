# Week 03 学习笔记

## 知识点



## 作业

- [x] 17: 电话号码字母组合 `*****` `M`
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
  
  > 1: 回溯：level = 当前处理第几个数字



- [x] : 全排列 `*****` `M` //TODO
https://leetcode.com/problems/permutations/
  > 1: 递归回溯
  > for i in 0~len, path.add(nums[i])
  > dfs(depth + 1)
  > 状态变量
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

