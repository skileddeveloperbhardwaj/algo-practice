package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Gaurav
 * 
 *         Problem: Given an integer array arr and an integer difference, return
 *         the length of the longest subsequence in arr which is an arithmetic
 *         sequence such that the difference between adjacent elements in the
 *         subsequence equals difference.
 *
 */
public class LongestArithmeticSubsequence {
	public static int longestSubsequence(int[] arr, int difference) {
		int[] len = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			len[i] = 1;
		}

		int max = len[0];

		for (int i = 1; i < len.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (((arr[i] - arr[j]) == difference) && len[i] <= len[j] + 1) {
					len[i] = len[j] + 1;
					if (max < len[i]) {
						max = len[i];
					}
				}
			}
		}

		return max;
	}

	public static int longestSubsequenceUsingSet(int[] arr, int difference) {
		Map dp = new HashMap<Integer, Integer>();
		int max = 1;
		for (int i = 0; i < arr.length; i++) {
			if (dp.containsKey(arr[i] - difference)) {
				dp.put(arr[i], (Integer) dp.get(arr[i] - difference) + 1);
				max = Math.max(max, ((Integer) dp.get(arr[i])));
			} else {
				dp.put(arr[i], 1);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.print(longestSubsequenceUsingSet(new int[] { 1, 2, 3, 4 }, 1));
	}

}
