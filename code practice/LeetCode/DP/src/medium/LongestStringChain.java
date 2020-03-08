package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestStringChain {
	public static void main(String[] args) {
		LongestStringChain chain = new LongestStringChain();
		String[] words = new String[] { "ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh",
				"zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru" };// {"a","b","ba","bca","bda","bdca"};

		int count = chain.longestStrChain(words);
		System.out.println(count);
	}

	public int longestStrChain(String[] words) {
		int count = 0;
		int[] len = new int[words.length];
		
		Comparator<String> byLength = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		};
		
		Arrays.sort(words, byLength);
		
		int[] chainCount = new int[words.length];
		Arrays.fill(chainCount, 1);

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < i; j++) {
				if (isValidWords(words[i], words[j])) {
					chainCount[i] = chainCount[j] + 1;
				}
			}

		}

		for (int i = 0; i < words.length; i++) {
			count = Math.max(chainCount[i], count);
		}

		return count;

	}

	private boolean isValidWords(String a, String b) {
		// TODO Auto-generated method stub
		if(a.length() != b.length()+1) {
			return false;
		}
		
		int count  = 0;
		for(int i=0,j=0;i<a.length() && j<b.length();) {
			if(a.charAt(i) == b.charAt(j)) {
				i++;
				j++;
			} else {
				count++;
				i++;
			}
		}
		return count <= 1;
	}

}
