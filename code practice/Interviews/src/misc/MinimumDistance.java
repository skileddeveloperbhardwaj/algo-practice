package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MinimumDistance {
    //Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 5, 9}
    public static int getMinimumSteps(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int[] route = new int[arr.length];
        dp[0] = 0;
        route[0] = 0;
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<=arr[i];j++) {
                if(i+j >= arr.length) continue;
                if(dp[i+j] < dp[i]+1) {
                    dp[i+j] = dp[i+j];
                } else {
                    dp[i+j] = dp[i]+1;
                    route[i+j] = i;
                }
            }
        }

        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1;i>0;) {
            s.push(arr[route[i]]);
            i = route[i];
        }

        while(!s.empty()) {
            System.out.print(s.pop()+"-->");
        }
        System.out.println();
        return dp[arr.length-1];
    }

    public static void main(String[] args) {
        System.out.println(getMinimumSteps(new int[]{2, 3, 1, 1, 2, 4, 2, 0, 1, 1}));
    }
}
