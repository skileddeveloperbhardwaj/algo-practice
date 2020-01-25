package medium;

import java.util.Stack;

public class FriendCircles {
	public static void main(String[] args) {
		int[][] M = new int[][] {
			{1,1,0},
			 {1,1,0},
			 {0,0,1}
		};
		
		System.out.println(findCircleNum(M));

	}

	public static int findCircleNum(int[][] M) {
		int count = 0;
		boolean[] visited = new boolean[M.length];

		for (int i = 0; i < M.length; i++) {
			if (!visited[i]) {
				findCircleDfs(i, M, visited);
				count++;
			}
		}
		return count;
	}

	private static void findCircleDfs(int i, int[][] m, boolean[] visited) {

		for (int j = 0; j < m.length; j++) {
			if (m[i][j] == 1 && !visited[j]) {
				visited[j] = true;
				findCircleDfs(j, m, visited);
			}
		}

	}

}
