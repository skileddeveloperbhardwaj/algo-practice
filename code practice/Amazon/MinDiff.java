package medium;

import java.util.Scanner;

public class MinDiff {

	public static void main(String[] args) {
		int tc;
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			int min;
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}

			// calculate min diff
//			min = minDiffOnsquare(arr, n);
			min = minDiffON(arr, n);
			System.out.println(min);
		}
	}

	private static int minDiffON(int[] arr, int n) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		int diff;
		int pos = 0;
		int a[] = new int[100005];
		for (int i = 0; i < n; i++) {
			a[arr[i]]++;
			if (a[arr[i]] > 1) {
				return 0;
			}
			arr[pos++] = arr[i];
		}

		for (int i = 0; i < n-1; i++) {
			diff = arr[i + 1] - arr[i];
			if (diff < min) {
				min = diff;
			}
		}
		return min;
	}

	private static int minDiffOnsquare(int[] arr, int n) {
		int min = Integer.MAX_VALUE;
		for (int k = 1; k < n; k++) {
			for (int l = 0; l < k; l++) {
				int diff = Math.abs(arr[k] - arr[l]);
				if (diff < min) {
					min = diff;
				}
			}
		}
		return min;

	}
}
