package shortestpath;

/**
 * 
 * Dijkstra’s shortest path algorithm | Greedy Algo-7
 * 
 * Given a graph and a source vertex in the graph, find shortest paths from
 * source to all vertices in the given graph.
 * 
 * @author Gaurav
 *
 */
public class Dijkstra {
	static int V = 9;
     public static void main(String[] args) {
    	 int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                                     {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                                     {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                                     {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                                     {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                                     {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                                     {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                                     {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                                     {0, 0, 2, 0, 0, 0, 6, 7, 0} 
                                    };
         Dijkstra spt = new Dijkstra();
         spt.printShortestPathTree(graph, 0);
     }

	/**
	 * This method prints shortest path distance from source vertex to all other
	 * vertices.
	 * 
	 * @param graph --> given graph
	 * @param src   --> source vertex
	 */
	private void printShortestPathTree(int[][] graph, int src) {
		// TODO Auto-generated method stub
		boolean[] sptSet = new boolean[V];// shortest path tree set: its similar to visited array in BFS. It stores all
											// those vertices which are part of SPT i.e whose shortest distance has been
											// calculated
		int[] dist = new int[V];// it stores distances of all vertices from source vertices.

		// sptSet and dist arrays initialisations
		for (int i = 0; i < V; i++) {
			sptSet[i] = false;
			dist[i] = Integer.MAX_VALUE;
		}

		// initialise src distance from itself as 0.
		dist[src] = 0;

		// implementation of Dijkstra algo
		for (int i = 0; i < V; i++) {
			// get minimum distanced vertex which is not present in sptSet
			int u = minDistanceVertex(sptSet, dist);
			sptSet[u] = true;
			for (int j = 0; j < V; j++) {
				if (!sptSet[j] && graph[u][j] != 0 && dist[u] != Integer.MAX_VALUE && dist[j] > graph[u][j] + dist[u]) {
					dist[j] = graph[u][j] + dist[u];
				}
			}
		}

		printSolution(dist);
	}

	private void printSolution(int[] dist) {
		// TODO Auto-generated method stub
		for (int i = 0; i < V; i++) {
			System.out.print(dist[i] + " ");
		}
	}

	private int minDistanceVertex(boolean[] sptSet, int[] dist) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		int src = -1;
		for (int i = 0; i < V; i++) {
			if (sptSet[i] == false) {
				if (dist[i] < min) {
					min = dist[i];
					src = i;
				}
			}
		}
		return src;
	}
}
