package medium;

public class SubsetSum {
    static boolean equalPartition(int n, int arr[]) {
        boolean[][] dp = new boolean[n + 1][arr.length + 1];
        for (int i = 0; i <= arr.length; i++)
            dp[0][i] = true;
        for (int i = 1; i <= n; i++)
            dp[i][0] = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= arr.length; j++) {
                dp[i][j] = dp[i][j-1];
                if(i>=arr[j-1]) {
                    dp[i][j] = dp[i][j-1] || dp[i-arr[j-1]][j-1];
                }
            }
        }
        return dp[n][arr.length];
    }
}
