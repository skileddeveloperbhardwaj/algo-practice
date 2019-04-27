package BFS;

import java.util.LinkedList;

/* A graph has a set of vertices and edges */
public class Graph {
	private int V;  //no of vertices
	LinkedList<Integer> adj[]; //Adjacenct list: it will contain vertices adjacent to current vertex
	
	public Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) { //initialisation of adjacency list
			adj[i]=new LinkedList();
		}
	}
	
	/**
	 * Method to add edge to the Graph
	 * @param u source vertex
	 * @param v represents destination vertex
	 */
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	/**
	 * Method to return no. of vertices
	 * @return
	 */
	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	/**
	 * Method to return adjacency list
	 * @return
	 */
	public LinkedList<Integer>[] getAdj() {
		return adj;
	}

	public void setAdj(LinkedList<Integer>[] adj) {
		this.adj = adj;
	}

}
