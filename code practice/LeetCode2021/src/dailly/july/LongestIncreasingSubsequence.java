package dailly.july;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int i=0;i<nums.length;i++) {
            int index = Arrays.binarySearch(dp,0,len,nums[i]);
            if(index<0) {
                index = -(index+1);
            }
            dp[index] = nums[i];
            if(index == len) {
                len++;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
