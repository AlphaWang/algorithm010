# 学习笔记

## 知识点

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

- [ ] 621: 任务调度器 `*****` `M`
https://leetcode.com/problems/task-scheduler/
  > 不会！

- [ ] 647: 回文子串 `***` `M`
https://leetcode.com/problems/palindromic-substrings/
  > 不会！

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


## 预习