# Week01 学习笔记

## 知识点
概述
- 职业训练：拆分知识点、刻意练习、反馈
- 五步刷题法  
  1. 五分钟读题+思考；直接看解法；默写好的写法；
  2. 马上自己写，提交LeetCode；多种解法比较；
  3. 一天后重复做题；不同解法的熟练程度 -> 专项练习；
  4. 一周后反复练习；
  5. 面试前一周恢复性训练；
- 算法题最大的误区：只做一遍

数组、链表、跳表
- 原理和实现
- 时间空间复杂度
- 跳表：升维思想 + 空间换时间

栈、队列  
- Queue 的接口
  - offer() / add()  
  - poll() / remove()
  - peek() / element() null / exception

- Deque 的接口
  - getFirst() / getLast()
  - removeFirst() / removeLast()  : exception
  - addLast() / addFirst()
  - pollFirst() / pollLast()   : null
  - offerFirst() / offerLast() 

## 作业
- [x] 用 add first 或 add last 这套新的 API 改写 Deque 的代码

- [x] 26: 删除排序数组中的重复项 `****` `E`  
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
  > 1: 开辟新数组，遍历原数组 并拷贝非重复元素到新数组  
  > 2: 双指针遍历。碰到不相等的元素，则拷贝到index+1指针处


- [x] 189: 旋转数组 `****` `E`  
https://leetcode.com/problems/rotate-array/
  > 1: 计算需要移动的步数，for steps, 从后往前遍历数组 移动元素  
  > 2: 使用额外数据，暂存头部（或尾部）待移动的元素，再依次移动  
  > 3: 使用额外数据，直接计算目标下标 `(k+i) % length`       
  > 4: 三次翻转数组 ！   
  > 5: 环状替换 // TODO 精妙，待仔细研究

- [x] 21: 合并两个有序的链表 `*****` `E`  
https://leetcode.com/problems/merge-two-sorted-lists/ 
  > 1: 循环两个链表；最后处理剩余的  
  > 2: 递归：妙！

- [x] 88: 合并有序数组 `*****` `E`  
https://leetcode.com/problems/merge-sorted-array/
  > 1: 双指针从前往后遍历，如果nums1元素大，则往后挪动元素  
  > 2: 双指针从后往前遍历：从 m+n-1 --> 0   
  > 3: 双指针从后往前遍历：从 m-1 / n-1 --> 0 ，优化循环判断逻辑  
 
- [x] 1: Two Sum `***` `E`  
https://leetcode.com/problems/two-sum/
  > 1: 暴力解法：两重遍历   
  > 2: 哈希：遍历一遍，记录 Map<期望匹配值，index>；或记录 Map<元素值, index> 

- [x] 283: 移动零 `****` `E`  
https://leetcode.com/problems/move-zeroes/
  > 1: 双指针，一个遍历数组，一个记录已处理的位置   
  > 2: 快排思想  // TODO 待仔细研究    

- [x] 66: 加一  
https://leetcode.com/problems/plus-one/
  > 从后往前遍历，逐个+1，加完如果>10，则返回。   
  > 注意全9的情况，直接新建一个数组，首位为1，其余全0. （无需拷贝原始数组）

- [x] 641: 设计循环双端队列 `*****` `M`  
https://leetcode.com/problems/design-circular-deque/
  > 1: 链表
  >
  > 2: 数组，头尾指针 (浪费一个元素)  
  >    - 插入头：head = (head - 1 + capacity) % capacity;  
  >    - 插入尾：tail = (tail + 1) % capacity;  
  >    - 判空/满：head == tail / (tail + 1) % capacity == head   
  >
  > 3: 数组，头指针+size （不浪费元素）  
  >    - 插入头：head = (head - 1 + capacity) % capacity;  
  >    - 插入尾：(head + size) % capacity  
  >    - 判空/满：size == 0 / size == capacity  

- [x] 42: 接雨水 `*****` `H`  
https://leetcode.com/problems/trapping-rain-water/
  > 1: 暴力：对每个元素，遍历2遍分别计算 leftMax/rightMax  
  > 2: DP： 双指针两次遍历，计算每个元素的 leftMax/rightMax，存入数组  
  > 3: DP优化：双指针夹逼  
  > 4: 栈：(?) // TODO 不太懂

## 预习
- [x] 242: Valid Anagram `*****` `E`  
https://leetcode.com/problems/valid-anagram/ 
  > 1: 先排序，再比较   
  > 2: Map 计数，比较Map是否相同   
  > 3: int[26] 计数    

- [ ] 94: 二叉树中序遍历 `*****` `M`  
https://leetcode.com/problems/binary-tree-inorder-traversal/

- [ ] 面试40: 最小的K个数   
https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/