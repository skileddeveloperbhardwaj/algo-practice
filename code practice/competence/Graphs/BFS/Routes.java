package BFS;

import java.util.LinkedList;

public class Routes {
	public static void main(String[] args) {
		int routes[][] = {{0,2500,3000,7000},
				          {0,0,0,3000},
				          {0,0,0,2000},
				          {0,0,0,0}};
		BFS(routes,0,3);
	}

	private static void BFS(int[][] routes, int src, int dest) {
		// TODO Auto-generated method stub
		boolean[] visited = new boolean[4];
		int dist[] = new int[4];
		int[] path = new int[4];

		java.util.Queue q = new LinkedList<Integer>();
		q.add(src);

		for (int i = 0; i < 4; i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}

		visited[src] = true;
		dist[src] = 0;
		path[src] = src;
		while (!q.isEmpty()) {
			int stn = (int) q.peek();
			q.remove();

			for (int i = 0; i < 4; i++) {
				if (routes[stn][i] != 0) {
					if (visited[i] == false) {
						visited[i] = true;
						q.add(i);
					}

					if (dist[i] > dist[stn] + routes[stn][i]) {
						dist[i] = dist[stn] + routes[stn][i];
						path[i] = stn;
					}
				}
			}

		}
		int arr[] = new int[4];
		int k = 0;
		arr[k++] = dest;
		int i = dest;
		while(i != src) {
			arr[k++] = path[i];
			i = path[i];
		}
		while(k >= 0) {
			System.out.print(arr[k--] + " -->");
		}
		System.out.println(dist[3]);
	}
}
