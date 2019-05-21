package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * You are given a grid A of size , two integers () and Q tasks. Each task
 * contains two integers, (). Each cell in the grid is either empty cells
 * denoted by O (Capital English character 'o') or occupied cells denoted by .
 * Initially, you are at (Si,Sj). Find the minimum number of steps in which you have
 * to take to reach (Di,Dj) from (Di,Dj) without traversing the occupied cells.
 * 
 * In a single step, you can move from any cell (i,j) to the 4 neighboring cells
 * i.e. ( i+1,j), (i-1,j), (i,j+1) and (i,j-1) provided these cells are inside the grid A.
 * 
 * @author Gaurav
 *
 */

public class Grid {
	public static void main(String[] args) {
		int[][] graph = {{0,9,0},
				         {0,0,0},
				         {9,0,0},
		                };
		ItemPos src = new ItemPos(2, 2);
		// Test 1
		ItemPos dest;
		dest = new ItemPos(1, 1);
		int pathLength = BFSTraversal(graph, src, dest);
		System.out.println(pathLength);

		// Test 2
		dest = new ItemPos(1, 2);
		pathLength = BFSTraversal(graph, src, dest);
		System.out.println(pathLength);

		// Test 3
		dest = new ItemPos(0, 1);
		pathLength = BFSTraversal(graph, src, dest);
		if (pathLength == Integer.MAX_VALUE) {
			pathLength = -1;
		}
		System.out.println(pathLength);
	}

	/**
	 * This method finds the shortest path between src and dest.
	 * @param graph  given graph
	 * @param src   given src
	 * @param dest  given dest
	 * @return  path length from src to dest.
	 */
	private static int BFSTraversal(int[][] graph, ItemPos src, ItemPos dest) {
		// TODO Auto-generated method stub

		// Queue to store src and its adjacent nodes in graph
		Queue<ItemPos> q = new LinkedList<ItemPos>();

		// boolean array to store if current node is already visited or not.
		boolean[][] visited = new boolean[3][3];

		// integer array to store distance of all nodes from source node.
		int[][] dist = new int[3][3];

		// initially add src to queue
		q.add(src);

		// initialise all nodes with false and distances as max value
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				visited[i][j] = false;
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		// set source vertex as visited
		visited[src.getX()][src.getY()] = true;

		// set distance of src to be 0
		dist[src.getX()][src.getY()] = 0;
		int xDest = dest.getX();
		int yDest = dest.getY();

		// loop to fill distance matrix using BFS traversal
		while (!q.isEmpty()) {
			ItemPos item = q.peek();
			int xSrc = item.getX();
			int ySrc = item.getY();
			q.remove();
			if (xSrc == xDest && yDest == ySrc) {
				break;
			}
			// down movement
			if (isSafe(graph, xSrc + 1, ySrc)) {
				if (visited[xSrc + 1][ySrc] == false) {// if not visited then set as visited and add it to the queue
					q.add(new ItemPos(xSrc + 1, ySrc));
					visited[xSrc + 1][ySrc] = true;
				}
				// even if node is already visited then also it may have been a distance smaller
				// than its previous distance. Hence updating it.
				if (dist[xSrc + 1][ySrc] > dist[xSrc][ySrc] + 1) {
					dist[xSrc + 1][ySrc] = dist[xSrc][ySrc] + 1;
				}
			}

			// up movement
			if (isSafe(graph, xSrc - 1, ySrc)) {
				if (visited[xSrc - 1][ySrc] == false) {
					q.add(new ItemPos(xSrc - 1, ySrc));
					visited[xSrc - 1][ySrc] = true;
				}
				if (dist[xSrc - 1][ySrc] > dist[xSrc][ySrc] + 1) {
					dist[xSrc - 1][ySrc] = dist[xSrc][ySrc] + 1;
				}
			}

			// right movement
			if (isSafe(graph, xSrc, ySrc + 1)) {
				if (visited[xSrc][ySrc + 1] == false) {
					q.add(new ItemPos(xSrc, ySrc + 1));
					visited[xSrc][ySrc + 1] = true;
				}
				if (dist[xSrc][ySrc + 1] > dist[xSrc][ySrc] + 1) {
					dist[xSrc][ySrc + 1] = dist[xSrc][ySrc] + 1;
				}
			}

			// left movement
			if (isSafe(graph, xSrc, ySrc - 1)) {
				if (visited[xSrc][ySrc - 1] == false) {
					q.add(new ItemPos(xSrc, ySrc - 1));
					visited[xSrc][ySrc - 1] = true;
				}
				if (dist[xSrc][ySrc - 1] > dist[xSrc][ySrc] + 1) {
					dist[xSrc][ySrc - 1] = dist[xSrc][ySrc] + 1;
				}
			}
		}
		return dist[xDest][yDest];
	}

	private static boolean isSafe(int[][] graph, int x, int y) {
		// TODO Auto-generated method stub
		if (x >= 0 && x < 3 && y >= 0 && y < 3 && graph[x][y] != 9) {
			return true;
		}
		return false;
	}
}
