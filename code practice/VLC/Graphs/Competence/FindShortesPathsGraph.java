package BFS;

import java.util.LinkedList;
import java.util.Queue;

import Graph.Graph;

/**
 * This program finds all shortest paths between source and destination with in between stops.
 * QUeestion: Here, I have taken an example in which we have to travel from 1 o 4 with 2 and 3 as two in between stops.  
 * @author Gaurav
 *
 */
public class FindShortesPathsGraph {
	public static void main(String[] args) {
		
		// A harcoded array of size 5x5 is taken as an example.
		//1 -> source; 4 -> destination; 2,3 -> stops
		int arr[][] = { { 1, 0, 0, 0, 0 },
				        { 0, 0, 0, 0, 0 },
				        { 0, 2, 0, 4, 0 },
				        { 9, 0, 0, 9, 0 },
				        { 0, 0, 0, 3, 0 } };
		//initialise totalPaths with 1
		int totalPaths = 1;

		//loop to find path from 1->2;2->3;3->4
		//Assumption: if source is 'i' then next stop is 'i+1'. 
		//If stops array is different then we can modify it accordingly.
		for (int i = 1; i < 4; i++) {
			int paths = findAllShortestPaths(arr, i);
			//totalPaths is the permutations of all paths from 1 to 2 to 3 to 4
			totalPaths *= paths;
		}
		
		System.out.print(totalPaths);
	}

	/**
	 * Retruns total path from src to dest. 
	 * Pairs pf source and destinations are: 1->2; 2->3; 3->4
	 * @param arr
	 * @param src
	 * @return
	 */
	private static int findAllShortestPaths(int[][] arr, int src) {
		// TODO Auto-generated method stub
		int temp[][] = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp[i][j] = arr[i][j];
			}
		}

		// Replacing all elements in array with 9 if its not source and destination. Its
		// done because we have to consider every non-zero element as obstruction.
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				// if current elememt is not src, destination(i.e.next stop) and 0 then consider
				// it obstruction. For ex: if we are finding path from 1 to 2 then element with
				// value 3 and 4 are obstructions.
				if (temp[i][j] != src && temp[i][j] != (src + 1) && temp[i][j] != 0) {
					temp[i][j] = 9;
				}
			}
		}

		// finding position(x,y) of current source in given matrix
		ItemPos curr = getItemPosition(temp, src);

		// running BFS algo on temp matrix with src(having curr as position
		return BFS(temp, curr);
	}

	/**
	 * Returns x and y position of src in given matrix 
	 * @param temp  given NxN matrix
	 * @param src current source
	 * @return position x,y
	 */
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

	/**
	 * Modified BFS to calculate total number of shortest paths between source and destination.
	 * @param temp  given NxN matrix
	 * @param curr position(x,y) of src in given matrix
	 * @return total number of shortest paths from src to dest.
	 */
	private static int BFS(int[][] temp, ItemPos curr) {
		// TODO Auto-generated method stub
		//dist matrix to store distance of all elements from src
		int dist[][] = new int[5][5];
		
		//store paths of all elements from src
		int path[][] = new int[5][5];
		
		//stores if element is already visited or not.
		boolean visited[][] = new boolean[5][5];
		
		//a queue to store adjacent vertices to current src vertex
		Queue q = new LinkedList<ItemPos>();
		
		//initially adding curr(i.e.src) to queue
		q.add(curr);
		
		//initialising distance, path and visited arrays.
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dist[i][j] = Integer.MAX_VALUE; //initially distances of elemnts from src is maximum
				path[i][j] = 0; //path length of elements from src is 0
				visited[i][j] = false; //all elements initially are false.
			}
		}
		
		dist[curr.getX()][curr.getY()] = 0; //distance of src from itself is 0
		path[curr.getX()][curr.getY()] = 1; //path length of sc to itself is 1
		visited[curr.getX()][curr.getY()] = true; //set src element as false

		// Loop to fill distance, path and visited arrays.
		while (!q.isEmpty()) {
			// fetch front element;peek does not remove fron tlement in java.
			// In competence you have to implement your own queue. See implementation of
			// Queue.java in same package.
			ItemPos item = (ItemPos) q.peek();

			// removing front element
			q.remove();
			int x = item.x;
			int y = item.y;

			// traversing bottom element of src
			// if its safe to traverse and its value is not equal to 9(i.e. obstruction)
			if (isSafe(temp, x + 1, y)) {
				// if its not already visited then add it to queue and mark it as visited.
				if (visited[x + 1][y] == false) {
					q.add(new ItemPos(x + 1, y));
					visited[x + 1][y] = true;
				}

				// updating distance and number of paths of bottom element from current element
				// even if its already visited.
				if (dist[x + 1][y] > dist[item.getX()][item.getY()] + 1) {
					// if bottom element's distance is greater than +1 of current element then this
					// is the shortest path.
					dist[x + 1][y] = dist[item.getX()][item.getY()] + 1;

					// total number of paths is same as current element's path count because it is
					// the path which is shortest
					path[x + 1][y] = path[item.getX()][item.getY()];
				}

				// more shortest paths found
				else if (dist[x + 1][y] == dist[item.getX()][item.getY()] + 1)
					path[x + 1][y] += path[item.getX()][item.getY()];
			}

			// top traverse --> same as for bottom
			if (isSafe(temp, x - 1, y)) {
				if (visited[x - 1][y] == false) {
					q.add(new ItemPos(x - 1, y));
					visited[x - 1][y] = true;
				}

				// top --> same as for bottom
				if (dist[x - 1][y] > dist[item.getX()][item.getY()] + 1) {
					dist[x - 1][y] = dist[item.getX()][item.getY()] + 1;
					path[x - 1][y] = path[item.getX()][item.getY()];
				}
				// more shortest paths found
				else if (dist[x - 1][y] == dist[item.getX()][item.getY()] + 1)
					path[x - 1][y] += path[item.getX()][item.getY()];
			}

			// right traverse --> same as for bottom
			if (isSafe(temp, x, y + 1)) {

				if (visited[x][y + 1] == false) {
					q.add(new ItemPos(x, y + 1));
					visited[x][y + 1] = true;
				}

				// right --> same as for bottom
				if (dist[x][y + 1] > dist[item.getX()][item.getY()] + 1) {
					dist[x][y + 1] = dist[item.getX()][item.getY()] + 1;
					path[x][y + 1] = path[item.getX()][item.getY()];
				}
				// more shortest paths found
				else if (dist[x][y + 1] == dist[item.getX()][item.getY()] + 1)
					path[x][y + 1] += path[item.getX()][item.getY()];
			}

			// left traverse --> same as for bottom
			if (isSafe(temp, x, y - 1)) {
				if (visited[x][y - 1] == false) {
					q.add(new ItemPos(x, y - 1));
					visited[x][y - 1] = true;
				}

				// left --> same as for bottom
				if (dist[x][y - 1] > dist[item.getX()][item.getY()] + 1) {
					dist[x][y - 1] = dist[item.getX()][item.getY()] + 1;
					path[x][y - 1] = path[item.getX()][item.getY()];
				}
				// more shortest paths found
				else if (dist[x][y - 1] == dist[item.getX()][item.getY()] + 1)
					path[x][y - 1] += path[item.getX()][item.getY()];
			}

		}

		// fetching position of destination-> in this case its +1 value of src
		ItemPos pos = getItemPosition(temp, temp[curr.getX()][curr.getY()] + 1);

		// returns the total paths from src to destination
		return path[pos.getX()][pos.getY()];
	}

	/**
	 * Checks if x and y are safe to traverse
	 * 
	 * @param x -> x position in matrix
	 * @param y -> y position in matrix
	 * @return true if its safe to travel.
	 */
	private static boolean isSafe(int[][] arr, int x, int y) {
		// TODO Auto-generated method stub
		if (x >= 0 && x < 5 && y >= 0 && y < 5 && arr[x][y] != 9) {
			return true;
		}
		return false;
	}
}
