package misc;

public class TestClass {
    public static String findDifferentBinaryString(String[] nums) {
        String ans ="";
        for(int i=0; i<nums.length; i++)
            ans+=Integer.toString(1-(nums[i].charAt(i)-'0'));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findDifferentBinaryString(new String[]{"010","100", "101"}));
    }
}
