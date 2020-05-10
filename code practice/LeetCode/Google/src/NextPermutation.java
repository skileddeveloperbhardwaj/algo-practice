public class NextPermutation {
    public static void main(String[] args) {
//        int[] nums = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        int[] nums = {1,1};
        new NextPermutation().nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }

    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        //finds first pair in increasing order
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        //find number just greater than ith number
        if(i>=0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }
        //reverse after (i+1)th index
        reverse(nums, i + 1);

    }

    private void reverse(int[] nums, int start) {
        int j = nums.length - 1;
        while (start < j) {
            swap(nums, start, j);
            start++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
