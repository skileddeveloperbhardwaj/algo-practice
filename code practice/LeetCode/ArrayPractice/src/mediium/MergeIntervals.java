package mediium;

import java.util.*;

public class MergeIntervals {

	public static void main(String[] args) {
		int[][] intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] merged = new MergeIntervals().merge(intervals);
		
		for(int[] interval: merged) {
			System.out.println(interval[0]+","+interval[1]);
		}

	}

	public int[][] merge(int[][] intervals) {
		// sorting intervals array in ascending order of start time
		Collections.sort(Arrays.asList(intervals), new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] < o2[0] ? -1 : o1[0] == o2[0] ? 0 : 1;
			}
		});

		LinkedList<int[]> merged = new LinkedList<int[]>();
		for (int[] interval : intervals) {
//			System.out.println(interval[0]);
			if (merged.isEmpty() || (merged.getLast()[1] < interval[0])) {
				merged.add(interval);
			} else {
				merged.getLast()[1] = Math.max(interval[1], merged.getLast()[1]);
			}
		}
		
		return merged.toArray(new int[merged.size()][]);
	}

}
