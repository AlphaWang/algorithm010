# Week 04 学习笔记

## 知识点

DFS

- 递归写法

  ```
  visited = set()
  dfs(node, visited) {
    // terminator
    if (visited.contains(node)) {
      return;
    }
    
    visited.add(node);
    // process current node
    ...
    
    // drill down
    for next_node in node.children():
      if (!visited.contains(next_node)) {
        dfs(next_node, visited);
      }
  }
  ```

- 非递归写法

  ```
  dfs(tree) {
    visited = [];
    stack = [tree.root];
    
    while (stack) {
      node = stack.pop();
      visited.add(node);
      
      process(node);
      
      nodes = getNodes(node);
      stack.push(nodes);
    }
  }
  ```

  

BFS

- 代码模板

  ```
  bfs(node, start, end) {
    queue = []
    queue.append(start)
    visited.add(start)
    
    while queue:
      node = queue.poll();
      visited.add(node);
      
      process(node);
      
      nodes = getNodes(node)
      queue.offer(nodes)
  }
  ```



贪心算法

- 定义：在每一步选择中都采取在当前状态下最优的选择，从而希望全局最优。
- vs 动态规划：动态规划会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。
- 场景：图的最小生成树、哈夫曼编码；但对工程中的问题，一般不能得到全局最优解。
  - 问题能否分解成子问题；
  - 子问题的最优解能递推到最终问题的最优解；
- 例子：Coin Change, [1, 5, 10, 20] 选出最少的硬币拼出总数 --> 可选硬币是倍数关系，贪心算法适用。
- 难点：拿到一个题目，如何判断贪心算法可用？发



二分查找

- 二分查找的前提

  - 目标函数单调性：递增，或递减。
  - 存在上下界。
  - 能够通过索引访问。--> 链表不可二分搜索

- 代码模板

  ```
  left = 0;
  right = arr.length - 1;
  
  while (left <= right) {
    mid = left + (right - left) / 2;
    if (arr[mid] == target) {
       return mid;
    } else if (arr[mid] > target) {
       left = mid + 1;
    } else if (arr[mid] < target) {
       right = mid - 1;
    }
  }
  ```

  



## 作业

Simple
- [x] 860: 柠檬水找零 `*****` `E` 
  https://leetcode.com/problems/lemonade-change/

  > 遍历，记录可用的零钱数目；收到整钱后，对零钱数目扣减

- [x] 122: 股票买卖 `*****` `E`
  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/  

  > 2: 贪心（122）：只要后一天价格比前一天高，则前一天买 后一天卖

- [x] 455: 分发饼干 `*****` `E`
  https://leetcode.com/problems/assign-cookies/

  > 贪心，先排序，从最小的胃口还是满足 

- [x] 874: 模拟行走机器人 `*****` `E`
https://leetcode.com/problems/walking-robot-simulation/
  > 逐个解析 commands  ，
  >   如果是-1/-2，则更新方向  
  >   其他情况，for 0-command, 更新res = max(res, x*x + y*y)  
  >            注意如果碰到obstacle，则不动  

Medium
- [x] 127: 单词接龙 `*****` `M` (!!!)
https://leetcode.com/problems/word-ladder/
  > 1: DFS //TODO  
  > 2: BFS. 先构造patternMap，再从beginWord开始按层次遍历  
  > 3: BFS 优化。分别从 beginWord/endWord 往中间夹逼

- [x] 200: 岛屿数量 `*****` `M`
  https://leetcode.com/problems/number-of-islands/

  > 遍历矩阵，碰到1 --> res++，并且 DFS 遍历周边节点，置为0

- [x] 529: 扫雷游戏 `*****` `M`
https://leetcode.com/problems/minesweeper/
  > DFS
  >  - 遇到 M，标记，结束
  >  - 遇到 X，结束
  >  - 否则是 E，
  >     - 如果周边有雷，更新当前位置
  >     - 如果周边无雷，DFS 向四周扩散

- [x] 55: 跳跃游戏 `*****` `M`
https://leetcode.com/problems/jump-game/
  > 1: 从前往后遍历，将能走到的索引置为 true  
  > 2: 贪心：从前往后遍历，维护最大可达位置   
  > 3: 贪心：从后往前遍历，if (nums[i] + i >= endReachable) endReachable = i;

- [x] 33: 旋转数组的某个值(无重复值) `*****` `M`  
https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14425/Concise-O(log-N)-Binary-search-solution
  > 1: 暴力解法，遍历一遍 O(N)  
  > 2: 暴力解法优化：找到最小值，还原成有序数组 O(N) or O(logN)  
  > 3: 二分法：左右侧总有一个是有序的  

- [x] 74: 搜索二维矩阵 `*****` `M`
https://leetcode.com/problems/search-a-2d-matrix/
  > 1: 两步走：先二分找到 子数组；再查子数组  
  > 2: 矩阵其实是 M * N 的有序数组  

- [x] 153: 旋转数组最小值  `*****` `M`  
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
  > 1: 遍历，如果nums[i] < num[i-1]，则找到。O(N)  
  > 2: 二分查找：if nums[mid] < nums[right], 往左侧找   
  >             if nums[mid] > nums[right], 往右侧找  

- [x] 126: 单词接龙2 `*` `H`
https://leetcode.com/problems/word-ladder-ii/
  > 126: 找出"所有"从 beginWord 到 endWord 的最短转换序列  
  > 127: 找到从 beginWord 到 endWord 的最短转换序列的长度   
  > 1: BFS, queue存储当前处理的路径（单词列表） --》 TODO 执行超时   


- [x] 45: 跳跃游戏2 `*****` `H`
https://leetcode.com/problems/jump-game-ii/
  > 1: 动态规划 --TODO 击败11%，太慢  
  >      状态: dp[n] = 索引 n 到最后位置的 minSteps  
  >      状态转移方程：dp[n] = min{dp[n + 1...nums[n]]}   
  > 2: BFS, --TODO 超时  
  > 3: 贪心，从后往前查找，每次找出跨度最大的位置  
  > 4: 贪心  ，
  >    Let's say the range of the current jump is [curBegin, curEnd],   
  >    `reachable` is the farthest point that all points in [curBegin, curEnd] can reach.   
  >    
  >    Once the current point reaches curEnd, then trigger another jump,   
  >    and set the new curEnd with `reachable`


- [x] 433: 最小基因变化 `*****` `M`
https://leetcode.com/problems/minimum-genetic-mutation/
  
  > 1: BFS, 类似127 单词接龙


## 预习

- [x] 300: 最长上升子序列 `*****` `M`
https://leetcode.com/problems/longest-increasing-subsequence/
  > 2: DP，N平方   
  >    状态：`dp[i]` 从头到i的最长子序列长度  
  >    方程：for i 0-->n-1, j 0-->i-1, if a[j]<a[i] `dp[i] = max(dp[j]) + 1`
  > 