package easy;

public class FloodFill {
	public static void main(String[] args) {
		int[][] image = new int[][] {
			{0,0,0},{0,1,1}
				
		};
		
		System.out.print(floodFill(image,1,1,1)[0][0]);

	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int oldColor = image[sr][sc];
		image[sr][sc] = newColor;
		if(oldColor == newColor) {
			return image;
		}
		dfs(image, sr, sc, newColor, oldColor);
		return image;

	}

	private static void dfs(int[][] image, int i, int j, int newColor, int oldColor) {
		// left
		int x = image.length;
		int y = image[0].length;
		if (isSafe(i - 1, j, x, y, image, oldColor)) {
			image[i - 1][j] = newColor;
			dfs(image, i - 1, j, newColor, oldColor);
		}

		// top
		if (isSafe(i, j - 1, x, y, image, oldColor)) {
			image[i][j - 1] = newColor;
			dfs(image, i, j - 1, newColor, oldColor);
		}

		// bottom
		if (isSafe(i + 1, j, x, y, image, oldColor)) {
			image[i + 1][j] = newColor;
			dfs(image, i + 1, j, newColor, oldColor);
		}

		// right
		if (isSafe(i, j + 1, x, y, image, oldColor)) {
			image[i][j + 1] = newColor;
			dfs(image, i, j + 1, newColor, oldColor);
		}

	}

	private static boolean isSafe(int i, int j, int x, int y, int[][] grid, int oldColor) {
		// TODO Auto-generated method stub
		if (i >= 0 && j >= 0 && i < x && j < y && grid[i][j] == oldColor) {
			return true;
		}
		return false;
	}

}
