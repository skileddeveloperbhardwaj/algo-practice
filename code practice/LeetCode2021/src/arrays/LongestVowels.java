package arrays;

public class LongestVowels {
    public static int longestBeautifulSubstring(String word) {
        int maxLen = Integer.MIN_VALUE;
        int n = word.length();
        char[] ch = word.toCharArray();
        int prev;

        for (int i = 0; i < n; ) {
            prev = i;
            if (ch[i] != 'a') {
                i++;
                continue;
            }
            //a
            while (i < n - 1 && ch[i] == ch[i + 1]) {
                i++;
            }
            //e
            if (i == n - 1 || ch[i + 1] != 'e') {
                i++;
                continue;
            }
            i++;

            while (i < n - 1 && ch[i] == ch[i + 1]) {
                i++;
            }
            if (i == n) break;
            //i
            if (i == n - 1 || ch[i + 1] != 'i') {
                i++;
                continue;
            }
            i++;
            while (i < n - 1 && ch[i] == ch[i + 1]) {
                i++;
            }

            //o
            if (i == n - 1 || ch[i + 1] != 'o') {
                i++;
                continue;
            }
            i++;

            while (i < n - 1 && ch[i] == ch[i + 1]) {
                i++;
            }

            //u
            if (i == n - 1 || ch[i + 1] != 'u') {
                i++;
                continue;
            }
            i++;
            while (i < n - 1 && ch[i] == ch[i + 1]) {
                i++;
            }

            int len = i - prev + 1;
            maxLen = maxLen < len ? len : maxLen;

        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;

    }

    public static void main(String[] args) {
        System.out.println(longestBeautifulSubstring("aaaaaa"));
    }
}
