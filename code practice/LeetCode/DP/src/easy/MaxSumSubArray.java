package easy;

/**
 * 
 * @author Gaurav
 * 
 *         Given an integer array nums, find the contiguous subarray (containing
 *         at least one number) which has the largest sum and return its sum.
 *
 */

public class MaxSumSubArray {

	public static void main(String[] args) {
		System.out.print(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

	public static int maxSubArray(int[] nums) {

		int curr_sum = nums[0];
		int max_sum_so_far = nums[0];
		for (int i = 1; i < nums.length; i++) {
			curr_sum = Math.max(nums[i], curr_sum + nums[i]);
			if (max_sum_so_far < curr_sum) {
				max_sum_so_far = curr_sum;
			}
		}

		return max_sum_so_far;
	}

}
