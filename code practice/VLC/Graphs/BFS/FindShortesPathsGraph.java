package BFS;

import java.util.LinkedList;
import java.util.Queue;

import Graph.Graph;

public class FindShortesPathsGraph {
	public static void main(String[] args) {
		int arr[][] = { { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 2, 0, 4, 0 }, { 9, 0, 0, 9, 0 }, { 0, 0, 0, 3, 0 } };
		int totalPaths = 1;

		for (int i = 1; i < 4; i++) {
			int paths = findAllShortestPaths(arr, i);
			totalPaths *= paths;
		}
		
		System.out.print(totalPaths);
	}

	private static int findAllShortestPaths(int[][] arr, int src) {
		// TODO Auto-generated method stub
		int temp[][] = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (temp[i][j] != src && temp[i][j] != (src + 1) && temp[i][j] != 0) {
					temp[i][j] = 9;
				}
			}
		}

		ItemPos curr = getItemPosition(temp, src);
		return BFS(temp, curr);
	}

	private static ItemPos getItemPosition(int[][] temp, int src) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (temp[i][j] == src) {
					return new ItemPos(i, j);
				}
			}
		}
		return null;
	}

	private static int BFS(int[][] temp, ItemPos curr) {
		// TODO Auto-generated method stub
		int dist[][] = new int[5][5];
		int path[][] = new int[5][5];
		boolean visited[][] = new boolean[5][5];
		Queue q = new LinkedList<ItemPos>();
		q.add(curr);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (temp[i][j] == temp[curr.getX()][curr.getY()]) {
					dist[curr.getX()][curr.getY()] = 0;
					path[curr.getX()][curr.getY()] = 1;
					visited[i][j] = true;
				} else {
					dist[i][j] = Integer.MAX_VALUE;
					path[i][j] = 0;
					visited[i][j] = false;
				}
			}
		}

		while (!q.isEmpty()) {
			ItemPos item = (ItemPos) q.peek();
			q.remove();
			int x = item.x;
			int y = item.y;
			// bottom
			if (isSafe(x + 1, y) && temp[x + 1][y] != 9) {
				if (visited[x + 1][y] == false) {
					q.add(new ItemPos(x + 1, y));
					visited[x + 1][y] = true;
				}

				if (dist[x + 1][y] > dist[item.getX()][item.getY()] + 1) {
					dist[x + 1][y] = dist[item.getX()][item.getY()] + 1;
					path[x + 1][y] = path[item.getX()][item.getY()];
				}
				// additional shortest paths found
				else if (dist[x + 1][y] == dist[item.getX()][item.getY()] + 1)
					path[x + 1][y] += path[item.getX()][item.getY()];
			}

			// top
			if (isSafe(x - 1, y) && temp[x - 1][y] != 9) {
				if (visited[x - 1][y] == false) {
					q.add(new ItemPos(x - 1, y));
					visited[x - 1][y] = true;
				}

				// top
				if (dist[x - 1][y] > dist[item.getX()][item.getY()] + 1) {
					dist[x - 1][y] = dist[item.getX()][item.getY()] + 1;
					path[x - 1][y] = path[item.getX()][item.getY()];
				}
				// additional shortest paths found
				else if (dist[x - 1][y] == dist[item.getX()][item.getY()] + 1)
					path[x - 1][y] += path[item.getX()][item.getY()];
			}

			// right
			if (isSafe(x, y + 1) && temp[x][y + 1] != 9) {

				if (visited[x][y + 1] == false) {
					q.add(new ItemPos(x, y + 1));
					visited[x][y + 1] = true;
				}

				// right
				if (dist[x][y + 1] > dist[item.getX()][item.getY()] + 1) {
					dist[x][y + 1] = dist[item.getX()][item.getY()] + 1;
					path[x][y + 1] = path[item.getX()][item.getY()];
				}
				// additional shortest paths found
				else if (dist[x][y + 1] == dist[item.getX()][item.getY()] + 1)
					path[x][y + 1] += path[item.getX()][item.getY()];
			}

			// left
			if (isSafe(x, y - 1) && temp[x][y - 1] != 9) {
				if (visited[x][y - 1] == false) {
					q.add(new ItemPos(x, y - 1));
					visited[x][y - 1] = true;
				}

				// left
				if (dist[x][y - 1] > dist[item.getX()][item.getY()] + 1) {
					dist[x][y - 1] = dist[item.getX()][item.getY()] + 1;
					path[x][y - 1] = path[item.getX()][item.getY()];
				}
				// additional shortest paths found
				else if (dist[x][y - 1] == dist[item.getX()][item.getY()] + 1)
					path[x][y - 1] += path[item.getX()][item.getY()];
			}

			// check if there is a better path.

		}
		ItemPos pos = getItemPosition(temp, temp[curr.getX()][curr.getY()]+1);
		return path[pos.getX()][pos.getY()];
	}

	private static boolean isSafe(int x, int y) {
		// TODO Auto-generated method stub
		if (x >= 0 && x < 5 && y >= 0 && y < 5) {
			return true;
		}
		return false;
	}
}

