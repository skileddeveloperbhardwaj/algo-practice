public class PlusOne {
    public static void main(String[] args) {
        int[] nums = {9, 9, 9};
        nums = new PlusOne().plusOne(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
        }
        if (digits[0] == 0) {
            int[] arr = new int[digits.length+1];
            arr[0] = 1;
            for(int i=1;i<arr.length;i++) {
                arr[i] = 0;
            }
            return arr;
        }
        return digits;
    }
}
