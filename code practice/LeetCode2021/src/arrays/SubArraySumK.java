package arrays;

public class SubArraySumK {
    public static int subarraySum(int[] nums, int k) {
        int ans = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == k) {
                ans++;
                continue;
            }
            int j = i+1;
            int sum = nums[i];

            while(j < nums.length) {
                sum += nums[j++];
                if(sum == k) ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,-1,0}, 0));
    }
}
