package BFS;

/**
 * This file contains BFS on a graph. Graph is represented in the form of adjacency matrix.
 * @author Gaurav
 *
 */
public class BFSImplAdjMatrix {
	public static void main(String[] args) {
		
		// Here graph is a weighted graph.Using weighted to make this implementation
		// clearer.
		int graph[][] = { { 0, 1, 1, 0 }, 
				          { 0, 0, 1, 0 }, 
				          { 1, 0, 0, 1 }, 
				          { 0, 0, 0, 1 } };
		int src = 2; //source vertex is 2
		BFSQueueImpl(graph, src, 4);
	}

	/**
	 * This method implements BFS on adjacency matrix.
	 * @param graph -> given graph
	 * @param src -> source vertex
	 * @param n -> nxn size adjacency matrix
	 */
	private static void BFSQueueImpl(int[][] graph, int src, int n) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		
		//this array stores if node is already visited or not.
		boolean visited[] = new boolean[n];
		
		//initialliy source added to queue.
		q.enQueue(src);
		
		//marked source node as visited
		visited[src] = true;

		//loop to implement BFS by visiting adjacent nodes to current source vertices.
		while (!q.isEmpty()) {
			//fetched element on front of queue.
			int s = q.deQueue();
			System.out.print(s+" ");
			
			// adding nodes adjacent to current source node 's' to queue.
			for (int j = 0; j < n; j++) {
				// if jth node is adjacent node to source 's' is not yet visited then add it to
				// queue and mark it as visited.
				if (visited[j] == false && graph[s][j] == 1) {
					q.enQueue(j); //adding to queue
					visited[j] = true; //marking it as visited
				}
			}

		}

	}
}
