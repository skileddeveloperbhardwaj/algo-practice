package easy;

import java.util.List;
import java.util.Vector;

public class HouseRobber {
	public static int rob(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0],nums[1]);

		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-1],nums[i] + dp[i-2]);
		}
		
		int max = dp[0];
		for(int i=0;i<nums.length;i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		return max;

	}

	public static void main(String[] args) {
		System.out.println(rob(new int[] { 1, 2, 3, 1 }));
		List list = new Vector();
	}

}
