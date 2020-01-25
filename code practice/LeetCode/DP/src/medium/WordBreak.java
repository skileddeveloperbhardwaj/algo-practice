package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordBreak {
	public static boolean wordBreak(String s, List<String> wordDict) {

		if (s.isEmpty()) {
			return true;
		}
		Set<String> wordSet = new HashSet<String>(wordDict);
		Queue<Integer> indexQueue = new LinkedList<Integer>();
		indexQueue.add(0);
		int[] visited = new int[s.length()];

		while (!indexQueue.isEmpty()) {
			int start = indexQueue.remove();

			if (visited[start] == 0) {
				for (int end = start + 1; end <= s.length(); end++) {
					if (wordSet.contains(s.substring(start, end))) {
						indexQueue.add(end);
						if (end == s.length()) {
							return true;
						}
					}
				}
			}
			visited[start] = 1;
		}

		return false;
	}

	// DP solution
	public static boolean wordBreakDP(String s, List<String> wordDict) {
		int len = s.length();
		boolean[] dp = new boolean[len + 1];
		dp[0] = true; // all empty strings are part of wordDict
		Set<String> wordSet = new HashSet<String>(wordDict);

		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordSet.contains(s.substring(j + 1, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[len];
	}

	public static void main(String[] args) {
		List<String> wordDict = new ArrayList();
		wordDict.add("cats");
		wordDict.add("cat");
		wordDict.add("sand");
		wordDict.add("dog");
		wordDict.add("and");
		System.out.println(wordBreakDP("catsandog", wordDict));
	}
}
