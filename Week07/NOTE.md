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

A* 代码模板 
``` 
	public class AStar
	{
		public final static int BAR = 1; // 障碍值
		public final static int PATH = 2; // 路径
		public final static int DIRECT_VALUE = 10; // 横竖移动代价
		public final static int OBLIQUE_VALUE = 14; // 斜移动代价
		
		Queue<Node> openList = new PriorityQueue<Node>(); // 优先队列(升序)
		List<Node> closeList = new ArrayList<Node>();
		
		/**
		 * 开始算法
		 */
		public void start(MapInfo mapInfo)
		{
			if(mapInfo==null) return;
			// clean
			openList.clear();
			closeList.clear();
			// 开始搜索
			openList.add(mapInfo.start);
			moveNodes(mapInfo);
		}
	

		/**
		 * 移动当前结点
		 */
		private void moveNodes(MapInfo mapInfo)
		{
			while (!openList.isEmpty())
			{
				Node current = openList.poll();
				closeList.add(current);
				addNeighborNodeInOpen(mapInfo,current);
				if (isCoordInClose(mapInfo.end.coord))
				{
					drawPath(mapInfo.maps, mapInfo.end);
					break;
				}
			}
		}
		
		/**
		 * 在二维数组中绘制路径
		 */
		private void drawPath(int[][] maps, Node end)
		{
			if(end==null||maps==null) return;
			System.out.println("总代价：" + end.G);
			while (end != null)
			{
				Coord c = end.coord;
				maps[c.y][c.x] = PATH;
				end = end.parent;
			}
		}
	

		/**
		 * 添加所有邻结点到open表
		 */
		private void addNeighborNodeInOpen(MapInfo mapInfo,Node current)
		{
			int x = current.coord.x;
			int y = current.coord.y;
			// 左
			addNeighborNodeInOpen(mapInfo,current, x - 1, y, DIRECT_VALUE);
			// 上
			addNeighborNodeInOpen(mapInfo,current, x, y - 1, DIRECT_VALUE);
			// 右
			addNeighborNodeInOpen(mapInfo,current, x + 1, y, DIRECT_VALUE);
			// 下
			addNeighborNodeInOpen(mapInfo,current, x, y + 1, DIRECT_VALUE);
			// 左上
			addNeighborNodeInOpen(mapInfo,current, x - 1, y - 1, OBLIQUE_VALUE);
			// 右上
			addNeighborNodeInOpen(mapInfo,current, x + 1, y - 1, OBLIQUE_VALUE);
			// 右下
			addNeighborNodeInOpen(mapInfo,current, x + 1, y + 1, OBLIQUE_VALUE);
			// 左下
			addNeighborNodeInOpen(mapInfo,current, x - 1, y + 1, OBLIQUE_VALUE);
		}
	

		/**
		 * 添加一个邻结点到open表
		 */
		private void addNeighborNodeInOpen(MapInfo mapInfo,Node current, int x, int y, int value)
		{
			if (canAddNodeToOpen(mapInfo,x, y))
			{
				Node end=mapInfo.end;
				Coord coord = new Coord(x, y);
				int G = current.G + value; // 计算邻结点的G值
				Node child = findNodeInOpen(coord);
				if (child == null)
				{
					int H=calcH(end.coord,coord); // 计算H值
					if(isEndNode(end.coord,coord))
					{
						child=end;
						child.parent=current;
						child.G=G;
						child.H=H;
					}
					else
					{
						child = new Node(coord, current, G, H);
					}
					openList.add(child);
				}
				else if (child.G > G)
				{
					child.G = G;
					child.parent = current;
					openList.add(child);
				}
			}
		}
	

		/**
		 * 从Open列表中查找结点
		 */
		private Node findNodeInOpen(Coord coord)
		{
			if (coord == null || openList.isEmpty()) return null;
			for (Node node : openList)
			{
				if (node.coord.equals(coord))
				{
					return node;
				}
			}
			return null;
		}
	

	

		/**
		 * 计算H的估值：“曼哈顿”法，坐标分别取差值相加
		 */
		private int calcH(Coord end,Coord coord)
		{
			return Math.abs(end.x - coord.x)
					+ Math.abs(end.y - coord.y);
		}
		
		/**
		 * 判断结点是否是最终结点
		 */
		private boolean isEndNode(Coord end,Coord coord)
		{
			return coord != null && end.equals(coord);
		}
	

		/**
		 * 判断结点能否放入Open列表
		 */
		private boolean canAddNodeToOpen(MapInfo mapInfo,int x, int y)
		{
			// 是否在地图中
			if (x < 0 || x >= mapInfo.width || y < 0 || y >= mapInfo.hight) return false;
			// 判断是否是不可通过的结点
			if (mapInfo.maps[y][x] == BAR) return false;
			// 判断结点是否存在close表
			if (isCoordInClose(x, y)) return false;
	

			return true;
		}
	

		/**
		 * 判断坐标是否在close表中
		 */
		private boolean isCoordInClose(Coord coord)
		{
			return coord!=null&&isCoordInClose(coord.x, coord.y);
		}
	

		/**
		 * 判断坐标是否在close表中
		 */
		private boolean isCoordInClose(int x, int y)
		{
			if (closeList.isEmpty()) return false;
			for (Node node : closeList)
			{
				if (node.coord.x == x && node.coord.y == y)
				{
					return true;
				}
			}
			return false;
		}
	}

```

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

## 预习