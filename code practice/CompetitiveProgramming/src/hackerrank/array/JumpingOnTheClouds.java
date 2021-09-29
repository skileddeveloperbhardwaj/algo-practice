package hackerrank.array;

import java.util.ArrayList;
import java.util.List;

public class JumpingOnTheClouds {
    public static void main(String[] args) {
        List c = new ArrayList();
        int[] arr = new int[]{0, 0, 0, 0, 1, 0};
        for(int i:arr) {
            c.add(i);
        }
        System.out.print(JumpingOnTheClouds.jumpingOnClouds(c));
    }

    public static int jumpingOnClouds(List<Integer> c) {
        int[] dp = new int[c.size()];
        dp[0] = 0;
        if (c.get(1) == 0) dp[1] = 1;
        else dp[1] = Integer.MAX_VALUE;

        for (int i = 2; i < c.size(); i++) {
            if (c.get(i) == 0) {
                dp[i] = 1 + (dp[i - 1] > dp[i - 2] ? dp[i - 2] : dp[i - 1]);
            } else {
                dp[i] = Integer.MAX_VALUE;
            }
        }
        return dp[c.size() - 1];
    }
}
