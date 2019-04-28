package BFS;

import DFS.DFSImpl;

/**
 * Driver Program to provide input to main programs.
 * 
 * @author Gaurav
 *
 */
public class DriverClass {
	public static void main(String[] args) {
		Graph g = new Graph(5);

		g.addEdge(0, 1); // 0---1
		g.addEdge(0, 2); // 0---2
		g.addEdge(1, 2); // 1---2
		g.addEdge(2, 0); // 2---0
		g.addEdge(2, 3); // 2---3
		g.addEdge(3, 3); // 3---3
		g.addEdge(1, 0); 
		// BFS Implementation run
		BFSImpl bfs = new BFSImpl();
		bfs.BFSTraversal(g, 2);

		//DFS iterative implementation run
		System.out.println();
		DFSImpl dfs = new DFSImpl();
		dfs.DFSIterativeTraversal(g, 2);
		
		//DFS recursive implementation run
		System.out.println();
		dfs.DFSRecTraversal(g, 2);
	}
}
