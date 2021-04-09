package medium;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.print(new DecodeWays().numDecodings("226"));
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int numDecodings(String s) {
        return helper(s, 0);
    }

    private int helper(String s, int index) {
        if (map.containsKey(index)) {
            return map.get(index);
        }

        if (s.length() == index) return 1;
        if (s.charAt(index) == '0') return 0;
        if (index == s.length() - 1) return 1;

        int ans = helper(s, index + 1);
        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ans += helper(s, index + 2);
        }
        map.put(index, ans);
        return ans;
    }

}