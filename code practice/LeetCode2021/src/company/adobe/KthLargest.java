package company.adobe;

import java.util.*;

public class KthLargest {
    ArrayList<Integer> arr;

    public static void main(String[] args) {
        System.out.print(new KthLargest(3, new int[]{4, 5, 8, 2}).add(3));
    }
//    public KthLargest(int k, int[] nums) {
//        this.k = k;
//        arr = new ArrayList<Integer>();
//        for(int i = 0;i<nums.length;i++) {
//            arr.add(nums[i]);
//        }
//        Collections.sort(arr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
//    }

    public int add1(int val) {
        int index = Collections.binarySearch(arr, val);
        if(index<0) {
            index++;
            index*=-1;
        }
        int size = arr.size()+1;
        int[] a = new int[size];
        for(int i=0;i<index;i++) {
            a[i] = arr.get(i);
        }
        a[index] = val;
        for(int i=index+1;i<size;i++) {
            a[i] = arr.get(i-1);
        }
        arr.clear();
        for(int i:a) {
            arr.add(i);
        }

        return a[size-k];
    }

    int k;
    PriorityQueue<Integer> queue;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for(int i = 0;i<nums.length;i++) {
            queue.add(nums[i]);
            if(queue.size()>k) queue.remove();
        }

    }

    //using priority queue
    public int add(int val) {
        queue.add(val);
        if(queue.size()>k) queue.remove();
        return queue.peek();
    }
}
