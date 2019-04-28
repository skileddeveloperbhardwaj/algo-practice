package DFS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import BFS.Graph;

/**
 * This class implements the DFS traversal using iterative approach.
 * @author Gaurav
 *
 */
public class DFSImpl {
	Stack<Integer> vStack; //vertex stack to store adjacent nodes

	/**
	 * Method to implement DFS traversal iteratively
	 * @param g Given graph
	 * @param s source vertex
	 */
	public void DFSTraversal(Graph g, int s) {
		int v = g.getV(); //number of vertices
		LinkedList<Integer> adj[] = g.getAdj(); //adjacency list
		boolean visited[] = new boolean[v]; //array to store if vertex is visited or not
		vStack = new Stack();

		vStack.push(s); //initially push source vertex into the stack
		visited[s] = true; //mark it as visited
		System.out.print("DFS traversal output: ");
		
		while (!vStack.isEmpty()) { //implementing loop
			int source = vStack.peek(); //fetches node on top
			vStack.pop();
			System.out.print(source+" ");//prints source vertex
			LinkedList<Integer> nodes = adj[source];
			Iterator<Integer> itr = nodes.listIterator();

			while (itr.hasNext()) { //loop to push and mark adjacent nodes of source vertex if not yet visited
				int node = itr.next();
				if (visited[node] != true) {
					visited[node] = true;
					vStack.push(node);
				}
			}
		}
	}
}

/*
   DFS traversal output: 2 3 0 1
   
   Dry Run:
   Graph:
   0--------1
  | |      _|
  | |     |
  | |    _|
   2____|____3]
   
   Run: source = 2
    vStack  |    Output
      2     |   
      0,3   |      2
      0     |      2,3
      1     |      2,3,0
     empty  |      2,3,0,1 -> final output
*/ 