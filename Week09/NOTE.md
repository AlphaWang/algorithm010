# Week 09 学习笔记

## 知识点

- 常规动态规划
    - 爬楼梯  
        ```
        f(n) = f(n-1) + f(n-2)
        ```
    - 不同路径  
        ```
        f(x, y) = f(x-1, y) + f(x, y-1)
        ```
    - 打家劫舍
        ```
        dp[i][0] = max{ dp[i-1][0], dp[i-1][1] } //不抢第i家
        dp[i][1] = dp[i-1][0] + nums[i] 
        ```
    - 最小路径和
        ```
        dp[i][j] = min{ dp[i-1][j], dp[i][j-1] } + nums[i][j]
        ``` 
    - 股票买卖
                   
- 高级动态规划
    - 复杂度来源：状态拥有更多维度、状态方程更复杂。
    - 举例：爬楼梯问题的深化
        - 1. 每次可以爬 1、2、3 步
        - 2. 每次可以爬 x[] 步
        - 3. 前后不能走相同的步数

## 作业

- [x] 387: 字符串中的第一个唯一字符 `*****` `E` 
https://leetcode.com/problems/first-unique-character-in-a-string/
  > 1: 两层循环
  > 2: 两次循环：1）记录次数、2）统计：
  > 3: 一次遍历，用 Hash + Set 存储
  >      Set: 已遍历过的元素
  >      LinkedHashMap: 非重复元素


- [x] 541: 反转字符串2 `*****` `E`
https://leetcode.com/problems/reverse-string-ii/
  > 1: 头尾指针夹逼

- [x] 344: 反转字符串 `*****` `E`
https://leetcode-cn.com/problems/reverse-string/
  > 1: 头尾指针夹逼

- [x] 151: 翻转字符串里的单词 `*****` `M`
https://leetcode.com/problems/reverse-words-in-a-string/
  > 1: 库函数：split(" +""), Collections.reverse(), String.join(" ", list)
  > 2: reverse 整个字符串 --> 单独reverse每个单词
  > 3: 逐个解析单词，放入栈 （Deque）；然后join deque

- [x] 557: 翻转字符串里的单词3 `*****` `E`
https://leetcode.com/problems/reverse-words-in-a-string-iii/
  > 1: 遍历，找到单词，再翻转
  >    Note: 按照开始节点遍历，无需特殊处理结束字符

- [x] 917: 仅仅反转字母 `*****` `E`
https://leetcode.com/problems/reverse-only-letters/
  > 1: 双指针夹逼  

- [x] 205: 同构字符串 `*****` `E`
https://leetcode.com/problems/isomorphic-strings/
  > 1: Map 记录"所在组的位置" 
  > 2: Map 记录 字符对应关系 --》 注意需要双向对比 
  > 3: encode: 将字符串编码为 所在组位置。

- [x] 680: 验证回文串2 `*****` `E`
https://leetcode.com/problems/valid-palindrome-ii/
  > 1: 双指针，如果遇到不等，则跳过start、"或"跳过end

- [x] 300: 最长上升子序列 `*****` `M`
https://leetcode.com/problems/longest-increasing-subsequence/
  > 1: 暴力，2N次方  
  > 2: DP，N平方 
  >    状态：`dp[i]` 从头到i的最长子序列长度  
  >    方程：for i 0-->n-1, j 0-->i-1, if a[j]<a[i] `dp[i] = max(dp[j]) + 1`
  > 
  > 3: 二分法，优化第二层循环，N(logN)
  >    维护数组LIS; 遍历数组，if a[i] > LIS[max], 插入LIS尾部; 否则，替换LIS中最早>a[i]的元素   
  > 

- [x] 8: 字符串转换整数 `*****` `M`
https://leetcode.com/problems/string-to-integer-atoi/
  > 1: 先解析 sign, 再 res * 10 + curr.
  >    注意：判断数据范围 >> 易出错！

- [x] 438: 找到字符串中所有字母异位词 `*****` `M`
https://leetcode.com/problems/find-all-anagrams-in-a-string/
  > 1: 暴力遍历，对比是否为字母异位词
  > 2: 滑动窗口

- [x] 5: 最长回文串 `*****` `M`
https://leetcode.com/problems/longest-palindromic-substring/
  > 1: 暴力，枚举 start/end，判断[start, end] 是否回文。O(N^3)
  > 2: 枚举中间点，注意奇偶。O(N^2)
  > 3: DP 
  >    状态 dp[i][j] : [i, j]子串是否回文 !!!!!
  >    方程  if s[i] == s[j], dp[i][j] = dp[i+1][j-1]  
  >         if s[i] != s[j], dp[i][j] = 0


- [x] 32: 最长有效括号 `*****` `H`
https://leetcode.com/problems/longest-valid-parentheses/
  > 1: 暴力，for i = n ~ 2, 遍历子串 检查是否 valid  
  > 2: 栈，保存index  
  >    保持栈底元素为当前已经遍历过的元素中「最后一个"没有被匹配的右括号"的下标」，即有效子串的分割线  
  > 3: DP  
  >    状态: dp[i] 从0~i的最长有效子串。注意如果i是左括号，则dp[i] = 0   
  >    方程: dp[i] = 2 + dp[i-1] + dp[i - dp[i-1] - 2]   
  >
  >         x = i - dp[i-1] - 1: 表示与i对应的左括号位置  
  >         1："2"，与x位置匹配的基础长度 2      
  >         2：dp[i-1]: 前一个位置的长度    
  >         3：dp[i - dp[i-1] - 2] 即 x - 1：x之前的长度  
  >         
  >   >> 这个状态转移方程，怎么想到的！！！ 
  >
  > 4: 正向+逆向遍历，记录左右括号个数    
  >          if left == right, 找到有效子串，更新max
  >          if left < right,  右括号多，重置数目，重新统计  
  >
  >    为何要逆向再来一遍？"(( ( (())" --> 如果只正向，i=2位置的左括号会导致后续的有效子串被忽略     


- [x] 115: 不同的子序列 `***` `H` ???
https://leetcode.com/problems/distinct-subsequences/
  > 1: DP
  >    状态：dp[i][j] 表示 T 的前i字符串可以有 S j字符串组成的最多个数
  >    方程： if S[j] == T[i], dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
  >         if S[j] != T[i], dp[i][j] = dp[i][j-1]

## 预习








