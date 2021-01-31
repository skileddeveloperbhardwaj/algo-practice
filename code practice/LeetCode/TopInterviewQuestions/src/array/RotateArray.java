package array;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        new RotateArray().rotate(nums, k);
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i]+",");
        }
    }

/* failed attempt
    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || nums.length == 1) {
            return;
        }

        if(nums.length <= k) {
            rotateSpecial(k, nums);
        }
        int pivot = nums.length-k;
        for(int i = 0;i<k;i++) {
            int item = nums[pivot+i];
            moveToArray(nums,pivot+i,i);
            nums[i] = item;
        }

    }

    private void rotateSpecial(int k, int[] nums) {
    }

    private void moveToArray(int[] nums, int end, int offset) {
        for(int i=end;i>offset;i--) {
            nums[i] = nums[i-1];
        }
    }
 */

// Brute force
    public void rotate(int[] nums, int k) {
        k%=nums.length;

        for(int i=0;i<k;i++) {
            int prev = nums[nums.length-1];
            for(int j=0;j<nums.length;j++) {
                int temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }
}
