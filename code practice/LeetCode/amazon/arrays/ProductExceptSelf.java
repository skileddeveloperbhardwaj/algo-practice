package amazon.arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int nums[] = new ProductExceptSelf().productExceptSelf(new int[]{1,2,3,4});
        for(int i:nums) {
            System.out.print(i+" ");
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[0] = 1;
        //to calculate left side product
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        //to calculate right side product
        for (int i = 1; i < nums.length; i++) {
            right[i] = right[i-1]*nums[nums.length-i];
        }

        //to store final product
        for(int i=0;i<nums.length;i++) {
            nums[i] = left[i]*right[nums.length-1-i];
        }
        return nums;
    }
}
