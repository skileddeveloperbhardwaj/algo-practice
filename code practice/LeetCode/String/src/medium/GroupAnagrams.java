package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> list = new GroupAnagrams().groupAnagrams(strs);
		for(List<String> l:list) {
			for(String s: l) {
				System.out.println(s+" ");
			}
			System.out.println("\n");
		}
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<List<String>>();
		HashSet<String> set = new HashSet<String>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for(int i=0;i<strs.length;i++) {
			char[] temp = strs[i].toCharArray();
			Arrays.sort(temp);
			String str = new String(temp);
			if(set.contains(str)) {
				List<String> l = (List)map.get(str);
				l.add(strs[i]);
				map.put(str, l);
			} else {
				List<String> l = new ArrayList<String>();
				l.add(strs[i]);
				set.add(str);
				map.put(str, l);
			}
		}
		
		for(String s: set) {
			list.add(map.get(s));
		}
		
		return list;

	}

}
