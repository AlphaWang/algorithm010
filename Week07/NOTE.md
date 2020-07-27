# Week 07 学习笔记

## 知识点

- Trie 树
    - 定义：字典树，Trie树，单词查找树，建树；
        - 节点本身不存储完整单词。
        - 从根节点到某一节点，其路径上的字符连起来，为该节点对应的字符串。
        - 每个节点的所有子节点路径代表的字符都不相同。
    - 应用：统计和排序字符串。最大限度减少字符串比较，查询效率比 hash 高
    - 思想：空间换时间，利用字符串公共前缀来降低查询时间。       

- 并查集 Disjoint Set
    - 使用场景：组团、配对问题。
    - 基本操作：
        - makeSet(s): 创建并查集。
        - unionSet(x, y): 合并不想交的集合。
        - find(x): 查找x所在的集合的代表。
    - 实现
        ```
        class UnionFind {
          int count = 0;
          int[] parent;
      
          public UnionFind(int n) { 
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
              parent[i] = i;
            }
          } 
      
          public int find(int p) {
            while (p != parent[p]) {   
              // parent[p] = parent[parent[p]];  // 路径压缩
              p = parent[p];
            }   
            return p;
          }   
      
          public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
          }
        }
        ``` 
      
- 高级搜索
  - 初级搜索
    - BFS / DFS
    - 优化：不重复（cache）、剪枝
    - 回溯：分步解决一个问题。当发现现有的分步答案不对，则取消上一步的计算。
  - 剪枝
  - 双向 BFS
  - 启发式搜索
    - 使用 PriorityQueue，使用 `估价函数` 作为排序依据。
    - 例题：Shortest Path、Sliding Puzzle

- AVL 树
  - 是一种完美平衡二叉树
  - 存储：平衡因子 Balance Factor = 左子树与右子树高度差
  - 如何平衡：
    - 右右子树：`左旋`
    - 左左子树：`右旋`
    - 左右子树：`左右旋`
    - 右左子树：`右左旋`
  - 不足：需要额外存储空间、调整次数频繁

- 红黑树
  - 近似平衡的二叉搜索树，保证左右子树高度差小于两倍
  - 条件
    1. 每个节点要么是红色、要么是黑色；
    2. 根节点是黑色；
    3. 每个叶子节点是空的、黑色的；
    4. 不能有相邻的两个红色节点；
    5. 从任一节点到每个叶子节点的路径包含的黑色节点数目必须相同；
    

## 作业
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
  > 扩展1：可以走的步伐改为 1、2、3 （Easy）
  > 扩展2：相邻两步不能相同 （Medium）


- [x] 208: 实现字典树 
https://leetcode.com/problems/implement-trie-prefix-tree/
  > 数组实现，定义 TrieNode
  > TrieNode 封装 get / put / contains

- [x] 547: 朋友圈 `***` `M`
https://leetcode.com/problems/friend-circles/
  > 1: DFS/BFS 类似岛屿问题，O(N^2)
  > 2: 并查集，O(N^3)

- [x] 200: 岛屿数量 `*****` `M`
https://leetcode.com/problems/number-of-islands/
  > 遍历矩阵，碰到1 --> res++，并且 DFS 遍历周边节点，置为0

- [x] 130: 被围绕的区域 `***` `M`
https://leetcode.com/problems/surrounded-regions/
  > 1: DFS
  > 2: 并查集 //TODO

- [x] 36: 有效数独 `*****` `M`
https://leetcode.com/problems/valid-sudoku/
  > 0: 用3个数组，分别存储 行、列、块 的已出现数字个数

Q: 有没有其他解法？

## 预习