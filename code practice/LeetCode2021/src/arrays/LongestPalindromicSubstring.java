package arrays;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int maxLen = 0;
        String res = "";

        for(int i=0;i<s.length()-1;i++) {
            String s1 = expandAroundCenter(s, i, i);
            String s2 = expandAroundCenter(s, i, i+1);
            if(s1.length() > s2.length()) {
                if(res.length() < s1.length()) {
                    res = s1;
                }
            } else {
                if(res.length() < s2.length()) {
                    res = s2;
                }
            }
        }
        return res;
    }

    private static String expandAroundCenter(String s, int l, int r) {
        if(s.charAt(l) != s.charAt(r)) return "";
        while(l>=0 && r<s.length() && (s.charAt(l)==s.charAt(r))) {
            l--;
            r++;
        }
        l++;
        r--;
        return s.substring(l,r+1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("d"));
    }
}
