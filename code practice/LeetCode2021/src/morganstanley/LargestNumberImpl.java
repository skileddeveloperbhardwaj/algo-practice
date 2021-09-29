package morganstanley;

import java.util.Collections;
import java.util.PriorityQueue;

public class LargestNumberImpl {
    private static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    private static int largest = Integer.MIN_VALUE;
    private static int size ;
    public static int getLargestNumber() {
        return largest;
    }

    public static void setNewValue(int num) {
//         if(largest < num) {
//             largest = num;
//         }
        if(!pq.isEmpty() && pq.size() == 2) {
            if(pq.peek() < num) {
                pq.poll();
                pq.add(num);
            }
        } else {
            pq.add(num);
        }
    }

    public static int getNthLargest(int n) {
        size = n;
        for(int i=0;i<size-1;i++) {
            pq.poll();
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        setNewValue(3);
        setNewValue(7);
        setNewValue(6);
        setNewValue(11);
        System.out.println(getNthLargest(3));
    }
}
