package easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] pair = twoSum(nums,9);
		System.out.println("Pair is: "+pair[0]+" "+pair[1]);
	}
	
	public static int[] twoSum(int[] nums, int target) {
		int[] pair = new int[2];
		for(int i=0;i<nums.length;i++) {
			int rem = Math.abs(target-nums[i]);
			for(int j=i+1;j<nums.length;j++) {
				if(rem == nums[j]) {
					pair[0] = i;
					pair[1] = j;
					break;
				}
			}
		}
		return pair;
	}
	
	//Solution using one-pass hashtable
	public static int[] twoSumUsingHash(int[] nums, int target) {
		Map<Integer,Integer> pair = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			int complement = target-nums[i];
			if(pair.containsKey(complement)) {
				return new int[] {pair.get(complement),i};
			}
			pair.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

}
