package strings.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubstring {
    public static void main(String[] args) {
        System.out.print(new LongestNonRepeatingSubstring().
                lengthOfLongestSubstring("abcaghijkl"));
    }
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int lastOccurrence = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                lastOccurrence = Math.max(map.get(s.charAt(i)), lastOccurrence);
            }
                max = Math.max(max, i-lastOccurrence+1);
                map.put(s.charAt(i), i+1);
        }

        return max;
    }

}
