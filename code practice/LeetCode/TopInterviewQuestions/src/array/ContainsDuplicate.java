package array;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        System.out.println(new ContainsDuplicate().containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return false;
            } else {
                set.add(nums[i]);
            }
        }
        return true;
    }
}
