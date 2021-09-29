package arrays;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        System.out.print(new PalindromicSubstrings().countSubstrings("abc"));
    }
    public int countSubstrings(String s) {
        int count = s.length();
        for(int k=2;k<=s.length();k++) {
            for(int i=0;i<s.length();i++) {
                if(i+k-1<s.length()) {
                    String str = s.substring(i, i + k);
                    if (isPalindrome(str)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean isPalindrome(String s) {
        int l=0;
        int h = s.length()-1;
        while (l<h) {
            if(s.charAt(l++) != s.charAt(h--))
                return false;
        }
        return true;
    }
}
