package easy;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		
	}
	
	public static int removeDuplicates(int[] nums) {
		int i=0;
		
		for(int j=1;j<nums.length;j++) {
			if(nums[1] != nums[j]) {
				i++;
				nums[i]=nums[j];
			}
		}
		
		return i+1;
	}

}
