package arrays;

import java.util.HashMap;
import java.util.Map;

public class MinWinSubstring {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> winMap = new HashMap<>();
        for(char ch:t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0)+1);
        }
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";

        while(right<s.length() && (left <= right)) {
            if(isWindowDesirable(tMap, winMap)) {
                winMap.put(s.charAt(left), winMap.getOrDefault(s.charAt(left),0)-1);
                if(minLen >(right-left+1)) {
                    res = s.substring(left, right);
                    minLen = (right-left+1);
                }
                left++;
            } else {
                winMap.put(s.charAt(right), winMap.getOrDefault(s.charAt(right),0)+1);
                right++;
            }
        }

        while(left <= right) {
            if(isWindowDesirable(tMap, winMap)) {
                winMap.put(s.charAt(left), winMap.getOrDefault(s.charAt(left),0)-1);
                if(minLen >(right-left+1)) {
                    res = s.substring(left, right);
                    minLen = (right-left+1);
                }
            }
            left++;
        }
        return res;
    }

    private static boolean isWindowDesirable(Map<Character, Integer> tMap, Map<Character, Integer> winMap) {
        if(winMap==null || winMap.isEmpty()) return false;
        for(Map.Entry<Character,Integer> e:tMap.entrySet()) {
            char ch = e.getKey();
            int val = e.getValue();

            if(winMap.getOrDefault(ch, 0) < val) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ab", "a"));
    }
}
