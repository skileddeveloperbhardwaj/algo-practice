import java.util.Collections;
import java.util.HashMap;

public class LongestSubstringTwo {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringTwo().lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) {
            return n;
        }
        int left = 0, right = 0;
        int maxLen = 2;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < n) {
            if (map.size() < 3) {
                map.put(s.charAt(right), right);
                right++;
            }

            if (map.size() == 3) {
                int delIdx = Collections.min(map.values());
                map.remove(s.charAt(delIdx));
                left = delIdx+1;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
