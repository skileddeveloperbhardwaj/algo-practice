package BFS;

/**
 * Driver Program to provide input to main programs.
 * 
 * @author Gaurav
 *
 */
public class DriverClass {
	public static void main(String[] args) {
		Graph g = new Graph(4);

		g.addEdge(0, 1); // 0---1
		g.addEdge(0, 2); // 0---2
		g.addEdge(1, 2); // 1---2
		g.addEdge(2, 0); // 2---0
		g.addEdge(2, 3); // 2---3
		g.addEdge(3, 3); // 3---3

		// BFS Implementation run
		BFSImpl bfs = new BFSImpl();
		bfs.BFSTraversal(g, 2);

	}
}
