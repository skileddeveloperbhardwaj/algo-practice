package mock.adobe;

public class PalindromeInteger {

    public static void main(String[] args) {
        System.out.print(new PalindromeInteger().isPalindrome(12251));
    }

    //    public boolean isPalindrome(int x) {
//        String str = x+"";
//        StringBuilder s = new StringBuilder(str);
//        String rev = s.reverse().toString();
//        if(str.equals(rev)) return true;
//        return false;
//    }
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false;

        int rev = 0;
        while (x > rev) {
            rev = rev*10+x%10;
            x/=10;
        }
        return (x==rev || x == rev/10);
    }

}
