package amazon.arrays;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> list = new GroupAnagrams().groupAnagrams(str);
        System.out.print(list);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        Set<String> set = new HashSet();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str:strs) {
            String sortStr = sort(str);
            set.add(sortStr);
            List list = map.get(sortStr);
            if(list == null) {
                list = new ArrayList();
            }
            list.add(str);
            map.put(sortStr, list);
        }

        for(String str:set) {
            anagrams.add(map.get(str));
        }
        return anagrams;
    }

    private String sort(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
