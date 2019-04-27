package BFS;

import java.util.LinkedList;

/* A graph has a set of vertices and edges */
public class Graph {
	private int V; // no of vertices
	private LinkedList<Integer> adj[]; // Adjacenct list: it will contain vertices adjacent to current vertex

	public Graph(int v) {
		V = v;
		for (int i = 0; i < v; i++) { // initialisation of adjacency list
			adj[i] = new LinkedList();
		}
	}

	/**
	 * Method to add an edge to the Graph
	 * 
	 * @param u source vertex
	 * @param v represents destination vertex
	 */
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}

}
