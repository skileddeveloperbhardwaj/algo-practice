package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author Gaurav
 * 
 * Problem: 841
 */
public class KeysNRooms {
	
	public static void main(String[] args) {
		KeysNRooms kr = new KeysNRooms();
		int[][] arr = {{1},{2},{3},{}};
		List<List<Integer>> rooms= new ArrayList<List<Integer>>();
		for(int i=0;i<arr.length;i++) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			for(int j=0;j<arr[i].length;j++) {
				a.add(arr[i][j]);
			}
			rooms.add(a);
		}
		
		System.out.print(kr.canVisitAllRooms(rooms));
	}
	
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[rooms.size()];
		queue.add(0);

		while (!queue.isEmpty()) {
			int src = queue.poll();
			visited[src] = true;
			for (Integer i : rooms.get(src)) {
				if (!visited[i]) {
					queue.add(i);
				}
			}
		}

		for (int i = 0; i < rooms.size(); i++) {
			if (!visited[i]) {
				return false;
			}
		}

		return true;
	}

}
