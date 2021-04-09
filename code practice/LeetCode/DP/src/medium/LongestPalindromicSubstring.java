package medium;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String seq = lps.longestPalindrome("babad");
        System.out.println(seq);
        System.out.println(Long.parseLong("9646324351"));
	}

	public String longestPalindrome(String s) {
		String str = "";
		boolean[][] P = new boolean[s.length()][s.length()];
		for(int i = 0;i<s.length();i++) {
			P[i][i] = true;
		}
		
		for(int i=0;i<s.length()-1;i++) {
			P[i][i+1] = s.charAt(i) == s.charAt(i+1);
		}
		
		for(int i = 0;i<s.length();i++) {
			for(int j=i+2;j<s.length();j++) {
				P[i][j] = P[i+1][j-1] && (s.charAt(i) == s.charAt(j));
			}
		}
		return str;

	}

}
