package medium;

/**
 * 
 * @author Gaurav 
 * Problem: Given a 2d grid map of '1's (land) and '0's (water),
 *         count the number of islands. An island is surrounded by water and is
 *         formed by connecting adjacent lands horizontally or vertically. You
 *         may assume all four edges of the grid are all surrounded by water.
 *         
 * Solution: Below solution is using DFS; can be done using BFS as well         
 *
 */
public class NumOfIslands {

	public static void main(String[] args) {

	}

	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int count = 0;
		int nr = grid.length;
		int nc = grid[0].length;

		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}

		}
		return count;
	}

	private static void dfs(char[][] grid, int r, int c) {
		// TODO Auto-generated method stub
		int nr = grid.length;
		int nc = grid[0].length;
		if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
			return;
		}

		grid[r][c] = '0';
		dfs(grid, r + 1, c);
		dfs(grid, r - 1, c);
		dfs(grid, r, c + 1);
		dfs(grid, r, c - 1);
	}

}
