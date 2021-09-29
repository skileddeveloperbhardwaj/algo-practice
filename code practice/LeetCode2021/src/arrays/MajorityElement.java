package arrays;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int currMajority = nums[0];
        int count =0;
        for(int i:nums) {
            count += (currMajority == i)?1:-1;
            if(count == 0) {
                currMajority = i;
                count++;
            }
        }
        return currMajority;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,3,2}));
    }
}
