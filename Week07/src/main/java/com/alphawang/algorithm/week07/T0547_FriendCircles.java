package com.alphawang.algorithm.week07;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/friend-circles/
 * Medium
 * 
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。
 * 他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。
 * 所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。
 * 如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。
 * 你必须输出所有学生中的已知的朋友圈总数。
 */
public class T0547_FriendCircles {

    /**
     * 1. DFS
     *    类似200 https://leetcode.com/problems/number-of-islands/
     *    
     *    错误！
     *           {1,0,0,1},
     *           {0,1,1,0},
     *           {0,1,1,1},
     *           {1,0,1,1}
     *    --> 4, 应该是 1
     *    
     *    解决：和岛屿问题不同，这里是 m 个人，可以标记每个人是否已被访问过
     */
    int[][] directions = new int[][] {
      {0, -1}, {0, 1}, {-1, 0}, {1, 0}
    };
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        
        int m = M.length;
        int n = M[0].length;
        boolean[][] visited = new boolean[m][n];
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(M, i, j, visited);
                }
            }
        }

        System.out.println(Arrays.deepToString(visited));
        return count;
    }

    private void dfs(int[][] m, int i, int j, boolean[][] visited) {
        if (visited[i][j] || m[i][j] == 0) {
            return;
        }
        
        visited[i][j] = true;
        for (int[] dir : directions) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI >= 0 && nextI < m.length && nextJ >= 0 && nextJ < m[0].length) {
                dfs(m, i + dir[0], j + dir[1], visited);
            }
        }
    }

    /**
     * 1_1: DFS
     * 
     *      O(N^2)
     *      0ms - 100%
     */
    public int findCircleNum1_1(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        int m = M.length;
        int count = 0;
        boolean[] visited = new boolean[m];
        for (int i = 0; i < m; i++) {
            System.out.println("-- checking " + i);
            if (!visited[i]) {
                System.out.println("--   adding " + i);
                count++;
                dfs2(M, visited, i);
            }
        }
        
        return count;
    }

    private void dfs2(int[][] m, boolean[] visited, int i) {
        for (int j = 0; j < m.length; j++) {
            if (!visited[j] && m[i][j] == 1) {
                visited[j] = true;
                dfs2(m, visited, j);
            }
        }
    }


    /**
     * 2. 并查集
     * 
     *    O(N^3)
     *    5ms - 25%
     */
    public int findCircleNum2(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        
        int m = M.length;
        JointSet jointSet = new JointSet(M.length);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1) {
                    jointSet.union(i, j);
                }
            }
        }

        System.out.println("joint-set: " + Arrays.toString(jointSet.parent));
        return jointSet.count;
    }

    static class JointSet {
        int count = 0;
        int[] parent;

        public JointSet(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];  // 路径压缩 5ms --> 1ms
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

    public static void main(String[] args) {
        /*
         * 输入: 
         * [[1,1,0],
         *  [1,1,0],
         *  [0,0,1]]
         * 输出: 2 
         * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
         * 第2个学生自己在一个朋友圈。所以返回2。
         */
        test(new int[][]{
          {1,1,0}, 
          {1,1,0},
          {0,0,1}
        });

        /*
         * 输入: 
         * [[1,1,0],
         *  [1,1,1],
         *  [0,1,1]]
         * 输出: 1
         * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
         */
        test(new int[][]{
          {1,1,0},
          {1,1,1},
          {0,1,1}
        });
        
        // 1
        test(new int[][]{
          {1,0,0,1},
          {0,1,1,0},
          {0,1,1,1},
          {1,0,1,1}
        });
    }
    
    private static void test(int[][] M) {
        T0547_FriendCircles sut = new T0547_FriendCircles();
        System.out.println(Arrays.deepToString(M));
        System.out.println("--> " + sut.findCircleNum1_1(M));
    }
}
