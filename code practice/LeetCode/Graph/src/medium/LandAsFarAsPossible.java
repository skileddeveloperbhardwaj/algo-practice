package medium;

import java.util.ArrayList;
import java.util.List;

public class LandAsFarAsPossible {
	int[] dr = { 1, 0, -1, 0 };
	int[] dc = { 0, 1, 0, -1 };
	int N;
	int[][] grid;
	int d;
	int[][] visited;
	
	public static void main(String[] args) {
		int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
		System.out.println(new LandAsFarAsPossible().maxDistance(grid));
	}

	public int maxDistance(int[][] grid) {
		N = grid.length;
		this.grid = grid;
        int d = 0;
        visited = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
                if(grid[r][c] == 0) {
                	dfs(r,c);
                }
			}
		}
        return d;
	}
	
	private void dfs(int r, int c) {
		visited[r][c] = 1;
		for(Integer move:neighbours(r,c)) {
			if(grid[move/N][move%N] == 1) {
				int dis = Math.abs(r-move/N)+Math.abs(c-move%N);
				d = Math.max(dis, d);
				return;
			} else if(visited[move/N][move%N] == 0) {
				dfs(move/N,move%N);
			}
		}
	}
	
	private List<Integer> neighbours(int r, int c) {
		int nr = 0, nc = 0;
		List<Integer> moves = new ArrayList<Integer>();
		for(int i = 0;i<4;i++) {
			nr = r+dr[i];
			nc = c+dc[i];
			if(nr>= 0 && nc >=0 && nr <N && nc <N) {
				moves.add(nr*N+nc);
			}
		}
		
		return moves;
	}
	

}
