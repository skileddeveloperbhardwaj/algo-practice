package leetcodecurated;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{2, 11}, {6, 16}, {11, 16}};
        System.out.print(new MeetingRoom2().minMeetingRooms2(intervals));
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        java.util.Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, Comparator.comparingInt(o -> o));
        allocator.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }

    public int minMeetingRooms2(int[][] intervals) {
        int count = 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
        }

        for (int i = 0; i < intervals.length; i++) {
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        for (int i = 0,j=0; i < intervals.length && j<intervals.length; i++) {
            if(start[i] < end[j]) count++;
            else j++;
        }
        return count;
    }
}
