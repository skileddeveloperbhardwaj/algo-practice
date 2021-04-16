package dp.easy;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.print(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = dp[1] = 0;

        for (int i = 2; i < cost.length + 1; i++) {
            dp[i] = Math.min(cost[i-1]+dp[i-1],cost[i-2]+dp[i-2]);
        }
        return dp[cost.length];
    }
}
