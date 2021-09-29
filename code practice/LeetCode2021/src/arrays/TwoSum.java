package arrays;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        System.out.print(new TwoSum().twoSum(new int[]{2,7,11,15}, 9)[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], i);
        }

        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(target-nums[i])) {
                int j=map.get(target-nums[i]);
                if(i != j)
                return new int[]{i,map.get(target-nums[i])};
            }
        }
        return null;
    }
}
