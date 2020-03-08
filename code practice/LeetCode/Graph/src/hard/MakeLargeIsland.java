package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MakeLargeIsland {

	int dr[] = { 1, 0, -1, 0 };
	int dc[] = { 0, 1, 0, -1 };
	int N;
	int[][] grid;

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		System.out.println(new MakeLargeIsland().largestIsland(grid));

	}

	public int largestIsland(int[][] grid) {
		this.grid = grid;
		int ans = 0;
		int index = 2;
		N = grid.length;
		int area[] = new int[N * N + 2];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (grid[r][c] == 1) {
					area[index] = dfs(r, c, index++);
				}
			}
		}

		for (int x : area)
			ans = Math.max(ans, x);

		// process for each 0
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (grid[r][c] == 0) {
					Set<Integer> seen = new HashSet<Integer>();
					for (Integer move : neighbours(r, c)) {
						if (grid[move / N][move % N] > 1) {
							seen.add(grid[move / N][move % N]);
						}
					}

					int bns = 1;
					for (int i : seen) {
						bns += area[i];
					}
					ans = Math.max(ans, bns);
				}
			}
		}

		return ans;

	}

	public int dfs(int r, int c, int index) {
		int ans = 1;
		grid[r][c] = index;
		for (Integer move : neighbours(r, c)) {
			if (grid[move / N][move % N] == 1) {
				grid[move / N][move % N] = index;
				ans += dfs(move / N, move % N, index);
			}
		}

		return ans;
	}

	private List<Integer> neighbours(int r, int c) {
		List<Integer> neighbours = new ArrayList<Integer>();
		int nr = 0, nc = 0;
		int N = grid.length;

		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				neighbours.add(nr * N + nc);
			}
		}

		return neighbours;
	}

}