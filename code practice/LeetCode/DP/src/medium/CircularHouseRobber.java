package medium;

public class CircularHouseRobber {
	
	public static int rob(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		if(nums.length == 1) {
			return nums[0];
		}
		
		if(nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		
		int inc0 = robUtil(nums,0,nums.length-1);
		int inc1 = robUtil(nums,1,nums.length);	

		return Math.max(inc0, inc1);
	}
	
	public static int robUtil(int[] nums, int i, int j) {
		int[] dp = new int[nums.length];
		dp[i] = nums[i];
		dp[i+1] = Math.max(nums[i], nums[i+1]);
		for (int k = i+2; k < j; k++) {
			dp[k] = Math.max(dp[k-1],nums[k] + dp[k-2]);
		}
		
		int max = dp[0];
		for(int k=1;k<j;k++) {
			if(max < dp[k]) {
				max = dp[k];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.print(rob(new int[] {0,7}));
	}

}
