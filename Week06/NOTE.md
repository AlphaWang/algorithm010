# Week 06 学习笔记

## 知识点


递归代码模板
```
public void recur(int level, int param) {
  // terminator
  if (level > MAX) {
    return;
  }         

  // process current level  
  process(level, param);

  // drill down 
  recur(level + 1, param);

  // restore current status 
  ...
}
```

分治代码模板
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

- 感触
  - 人肉递归低效
  - 找到最近最简方法，拆解成可重复解决的问题
  - 数学归纳法思维

动态规划：分治 + 最优子结构
- vs. 递归、分治
  - 共性：找到重复子问题
  - 差异：最优子结构，冲突可以淘汰次优解
  
- 关键点
  - 最优子结构 `dp[n] = bestOf(dp[n-1], dp[n-2], ...)`
  - 存储中间状态 `dp[i]`
  - 递推公式 `dp[i] = dp[i-1] + dp[i-2]`
  
- 例题
  - 斐波那契数列
  - 路径计算
  - 最长公共子序列  

## 作业

- [x] 64: 最小路径和 `*****` `M`
https://leetcode.com/problems/minimum-path-sum/
  > 1: DP 
  >    方程：dp[i][j] = min{dp[i][j+1], dp[i+1][j]} + nums[i][j]
  > 
  >    O(M*N), 3ms - 41%


- [x] 91: 解码方法 `*****` `M`
https://leetcode.com/problems/decode-ways/
  > 1: DP       
  > 状态：dp[i] 表示从 0~i 个元素的结果    
  > 方程：  
  >  1 如果当前元素为0：
  >    1.1 如果"能"和前一个数组成字母（prev == 1 or 2 ）：dp[i] = dp[i-2]  
  >    1.2 如果"不能"喝前一个数组成字母：                 dp[i] = 0      
  >  2 如果"能"和前一个数组成字母：  dp[i] = dp[i-1] + dp[i-2] // 单独构成字母  +  与前一个数组成字母   
  >  3 如果"不能"和前一个数组成字母：dp[i] = dp[i-1]           // 单独构成字母   

- [x] 221: 最大正方形 `*****` `M`
https://leetcode.com/problems/maximal-square/ 
  > 1: DP   
  >    状态 dp[i][j] : 以(i,j)元素为左上角的最大边长   
  >    方程 dp[i][j] = min{ dp[i+1][j], dp[i][j+1], dp[i+1][j+1] } + 1   
  >                    min{ 右方、下方、右下方 的最大边长 } + 1    
  >    
  >     此题状态方程，怎么想到的！！！

- [x] 621: 任务调度器 `***` `M`
https://leetcode.com/problems/task-scheduler/
  > 1: 排序，先排数目最多的任务：计算 idleSlot 个数    
  > TODO 不会！ 

- [x] 647: 回文子串 `*****` `M`
https://leetcode.com/problems/palindromic-substrings/
  > 1: DP  
  >    状态：dp[i][j] 表示字符串s在[i,j]区间的子串是否是一个回文串。  
  >    状态转移方程：当 s[i] == s[j] && (j - i <= 1 || dp[i + 1][j - 1]) 时，dp[i][j]=true，否则为false    
  > 
  > 2: 从中心扩展   
  >    区分长度为奇数、偶数的子串，分别处理     

- [x] 32: 最长有效括号 `*****` `H`
https://leetcode.com/problems/longest-valid-parentheses/
  > 1: 暴力，for i = n ~ 2, 遍历子串 检查是否 valid  
  > 2: 栈，保存index  
  >    保持栈底元素为当前已经遍历过的元素中「最后一个"没有被匹配的右括号"的下标」，即有效子串的分割线  
  > 3: DP  
  >    状态: dp[i] 从0~i的最长有效子串。注意如果i是左括号，则dp[i] = 0   
  >    方程: dp[i] = 2 + dp[i-1] + dp[i - dp[i-1] - 2]   
  >         x = i - dp[i-1] - 1: 表示与i对应的左括号位置  
  >         1："2"，与x位置匹配的基础长度 2      
  >         2：dp[i-1]: 前一个位置的长度    
  >         3：dp[i - dp[i-1] - 2] 即 x - 1：x之前的长度  
  >         
  >   这个状态转移方程，怎么想到的！！！ 
  >
  > 4: 正向+逆向遍历，记录左右括号个数   
  >    为何要逆向再来一遍？"(( ( (())" --> 如果只正向，i=2位置的左括号会导致后续的有效子串被忽略     

- [x] 72: 编辑距离 `*****` `H`
https://leetcode.com/problems/edit-distance/
  > 1: 暴力，bfs + queue  
  > 2: DP   
  >    状态：`dp[i,j]` word1的前i个字符，替换为word2前j个字符，需要的最少步数   
  >    方程：if w1[i] == w2[j], `dp[i,j] = dp[i-1,j-1]`;   
            if w1[i] != w2[j], `dp[i,j] = 1 + min{ dp[i-1,j], dp[i,j-1], dp[i-1,j-1] }`; //分别对应增/删/替换
  > 3: DP 可改为递归 
  >    DP - 自底向上
  >    递归 - 自顶向下

## 预习

 - TODO