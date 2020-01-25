package medium;

public class MaxAreaIsland {
	static int count = 1;
	public static void main(String[] args) {
		int[][] M = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		System.out.print(maxAreaOfIsland(M));
	}

	public static int maxAreaOfIsland(int[][] grid) {
		int maxAreaOfIsland = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                	count = 1;
                	dfs(grid, i,j);
                	if(count > maxAreaOfIsland) {
                		maxAreaOfIsland = count;
                	}
                }
			}
		}

		return maxAreaOfIsland;

	}

	private static void dfs(int[][] grid, int i, int j) {
		// TODO Auto-generated method stub
		grid[i][j] = 0;
		int x = grid.length;
		int y = grid[0].length;
		
		//left
		if(isSafe(i-1,j,x,y,grid)) {
			count++;
			grid[i-1][j] = 0;
			dfs(grid, i-1,j);
		}
		
		//top
		if(isSafe(i,j-1,x,y,grid)) {
			count++;
			grid[i][j-1] = 0;
			dfs(grid, i,j-1);
		}
		
		//bottom
		if(isSafe(i+1,j,x,y,grid)) {
			count++;
			grid[i+1][j] = 0;
			dfs(grid, i+1,j);
		}
		
		//right
		if(isSafe(i,j+1,x,y,grid)) {
			count++;
			grid[i][j+1] = 0;
			dfs(grid, i,j+1);
		}
	}

	private static boolean isSafe(int i, int j, int x, int y,int[][] grid) {
		// TODO Auto-generated method stub
		if(i>=0 && j>=0 && i<x && j<y && grid[i][j] != 0) {
			return true;
		}
		return false;
	}

}
