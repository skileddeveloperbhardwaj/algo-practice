package medium;

public class CountWays {

    public static void main(String[] args) {
        System.out.print(countWays(54));
    }

    static long countWays(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        if (n >= 1)
            dp[1] = 1;
        if (n >= 2)
            dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n]%1000000007;
    }

}
