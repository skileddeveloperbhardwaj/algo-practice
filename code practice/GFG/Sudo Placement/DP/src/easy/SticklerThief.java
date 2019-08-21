package easy;

import java.io.BufferedReader;
import java.io.IOException;

public class SticklerThief {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = Utils.getReader();
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] val = new int[n];
			String str = br.readLine();
			String[] s = Utils.getTrimmed(str);
			for (int j = 0; j < n; j++) {
				val[j] = Integer.parseInt(s[j]);
			}

			int maxVal = getMaxVal(val, n);
			System.out.println(maxVal);
		}
	}

	private static int getMaxVal(int[] val, int n) {
		// TODO Auto-generated method stub
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return val[0];
		}

		if (n == 2) {
			return Math.max(val[0], val[1]);
		}

		int[] dp = new int[n];
		dp[0] = val[0];
		dp[1] = Math.max(val[0], val[1]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + val[i]);
		}

		return dp[n - 1];
	}

}
