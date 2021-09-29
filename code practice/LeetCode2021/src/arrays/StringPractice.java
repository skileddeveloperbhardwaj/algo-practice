package arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class StringPractice {
    public static void main(String[] args) {
        String[] arr = {"1235", "12345", "321", null};
        Arrays.sort(arr);
        Queue<String> q = new ArrayDeque<>();
        for(String s:arr) {
            q.add(s);
        }

        for(String s:q) {
            System.out.println(s);
        }
    }
}
