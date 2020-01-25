package medium;

public class LIS {

	/**
	 * Output: Runtime: 15 ms, faster than 23.85% of Java online submissions for
	 * Longest Increasing Subsequence. Memory Usage: 40.5 MB, less than 5.00% of
	 * Java online submissions for Longest Increasing Subsequence.
	 * 
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		int len = nums.length;
		int[] lis = new int[len + 1];

		lis[0] = 0;

		int max = 0;

		for (int i = 1; i <= len; i++) {
			lis[i] = 1;
		}

		for (int i = 1; i <= len; i++) {
			for (int j = i - 1; j > 0; j--) {
				if (nums[i - 1] >= nums[j - 1] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
					if (max < lis[i]) {
						max = lis[i];
					}
				}
			}
		}

		return max;

	}

	public static void main(String[] args) {
		System.out.println(new LIS().lengthOfLIS(new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 }));

	}
}
