package strings.medium;

import java.util.HashMap;

public class LongestSubsequenceKTimes {
    public static void main(String[] args) {
        new LongestSubsequenceKTimes().longestSubsequenceWithK("aabbaabacabb", 5);
    }
    public void longestSubsequenceWithK(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        String outputString = "";
        for(int i=0;i<str.length();i++) {
            if(map.get(str.charAt(i))<k) continue;
            outputString+=str.charAt(i);
        }
        System.out.print(outputString);
    }
}
