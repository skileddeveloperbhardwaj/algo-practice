package strings.medium;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.print(new LongestPalindromicSubstring().longestPalindrome("goibibi"));
    }
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int l1 = expandAroundCorners(s, i, i);
            int l2 = expandAroundCorners(s, i, i + 1);
            int l = Math.max(l1, l2);
            if (l > end - start) {
                start = i - (l - 1) / 2;
                end = i + l / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCorners(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r-l-1;
    }
}
