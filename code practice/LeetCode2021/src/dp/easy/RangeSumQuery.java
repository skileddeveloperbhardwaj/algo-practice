package dp.easy;

public class RangeSumQuery {
    int[] dp;
    public RangeSumQuery(int[] nums) {
        dp = new int[nums.length+1];
        for(int i=1;i<=nums.length;i++) {
            dp[i] = nums[i-1]+dp[i-1];
        }
    }

    public int sumRange(int left, int right) {
         int sum = dp[right+1] - dp[left];
         return sum;
    }
}
