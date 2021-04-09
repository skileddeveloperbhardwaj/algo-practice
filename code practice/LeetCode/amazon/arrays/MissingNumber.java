package amazon.arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int missing = new MissingNumber().missingNumber(new int[]{0,1});
        System.out.print(missing);
    }

    public int missingNumber(int[] nums) {
        int max = findMax(nums);
        if(max<nums.length) {
            max = nums.length;
        }
        int allXOR = 0;
        int missingXOR = 0;
        for(int i=0;i<=max;i++) {
            allXOR^=i;
        }

        for(int i=0;i<nums.length;i++) {
            missingXOR^=nums[i];
        }

        return allXOR^missingXOR;
    }

    private int findMax(int[] nums) {
        int max = nums[0];

        for(int i=1;i<nums.length;i++) {
            if(max<nums[i])
                max = nums[i];
        }
        return max;
    }
}
