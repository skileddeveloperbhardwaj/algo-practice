package BFS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS Implementation program. Driver class provides it input in the form of
 * Graph g.
 * 
 * @author Gaurav
 *
 */
public class BFSImpl {
	private Queue<Integer> vQueue; // vertex queue, it stores the vertices in adjacency list

	/**
	 * Implementation of BFS
	 * 
	 * @param g graph on which BFS is performed
	 * @param s source vertex
	 */
	public void BFSTraversal(Graph g, int s) {
		vQueue = new LinkedList<Integer>();
		boolean[] visited = new boolean[g.getV()]; // visited array that marks a vertex true if its already visited to
													// avoid cycles
		LinkedList<Integer>[] adj = g.getAdj();

		vQueue.add(s); // adding source vertex to queue initially
		visited[s] = true; // marking source vertex as visited

		System.out.print("BFS output of given graph is: ")
		while (!vQueue.isEmpty()) {// loop to implement BFS. In this loop we are traversing graph breadth wise i.e.
									// layer-by-layer.
			int source = vQueue.poll();// source node fetched from queue's front
			System.out.print(source + " "); // source printed

			Iterator<Integer> itr = adj[source].listIterator(); // iterator to iterate over current source's adjacency
																// list
			while (itr.hasNext()) {
				int node = itr.next(); // next child node to source node
				if (visited[node] == false) { // check if its not visited then mark it as visited and add to queue
					visited[node] = true;
					vQueue.add(node); // adding child node to vertex queue
				}
			}
		}
		
		// OUTPUT--> BFS output of given graph is: 2 0 3 1
	}
}
