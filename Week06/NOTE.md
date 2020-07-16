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

## 预习