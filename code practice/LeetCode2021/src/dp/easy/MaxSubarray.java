package dp.easy;

public class MaxSubarray {
    public static void main(String[] args) {
        System.out.print(new MaxSubarray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = maxSum > currSum ? maxSum : currSum;
        }

        return maxSum;
    }
}
