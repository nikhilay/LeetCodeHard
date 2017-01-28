/**
 * Created by Nikhil on 1/28/17.
 */

/**
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down.
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/34835/15ms-concise-java-solution/2
 */
public class LongestIncreasingPathinAMatrix {
    int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null ||  matrix.length == 0 || matrix[0].length == 0 ) return 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = dfs(cache, matrix, i, j);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    private int dfs(int[][] cache, int[][] matrix, int row, int col) {
        if (cache[row][col] != 0) return cache[row][col];
        int max = 1;
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || matrix[row][col] >= matrix[r][c])
                continue;
            int len = 1 + dfs(cache, matrix, r, c);
            max = Math.max(max, len);
        }
        cache[row][col] = max;
        return max;
    }
}
