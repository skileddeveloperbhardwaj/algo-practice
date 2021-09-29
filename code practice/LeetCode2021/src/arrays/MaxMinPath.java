package arrays;

import java.util.Arrays;

public class MaxMinPath {
    public static int maximumMinimumPath(int[][] grid) {
        int r = 0;
        int c = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] dr = {0, -1, 0, 1};
        int[] dc = {-1, 0, 1, 0};
        int min = grid[0][0];
        boolean[][] visited = new boolean[m][n];
        for (boolean[] v : visited) {
            Arrays.fill(v, false);
        }

        visited[0][0] = true;

        while (r != m - 1 || c != n - 1) {
            int max = Integer.MIN_VALUE;
            int nr =r, nc=c;
            for (int i = 0; i < 4; i++) {
                int cr = r + dr[i];
                int cc = c + dc[i];

                if (isValid(m, n, cr, cc) && !visited[cr][cc] && grid[cr][cc] > max) {
                    max = grid[cr][cc];
                    nr = cr;
                    nc = cc;
                }
            }
//            System.out.println(r + "  " + c);
            r=nr;
            c=nc;
            visited[r][c] = true;
            if (min > grid[r][c]) {
                min = grid[r][c];
            }
        }

        if (min > grid[m - 1][n - 1]) {
            min = grid[m - 1][n - 1];
        }

        return min;
    }

    private static boolean isValid(int m, int n, int r, int c) {
        if (r >= 0 && r < m && c >= 0 && c < n) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{5, 4, 5},
                {1, 2, 6},
                {7, 4, 6}};

        System.out.println(maximumMinimumPath(grid));
    }
}
