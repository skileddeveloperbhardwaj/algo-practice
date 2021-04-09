package medium;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        List<Integer> r = new FindDisappearedNumbers().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        for(int i:r) {
            System.out.print(i+", ");
        }
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<nums.length;i++) {
            int newIndex = Math.abs(nums[i])-1;
            if(nums[newIndex] > 0) {
                nums[newIndex]*=-1;
            }
        }

        for(int i=0;i<nums.length;i++) {
            if(nums[i] >0) {
                result.add(i+1);
            }
        }

        return result;
    }
}
