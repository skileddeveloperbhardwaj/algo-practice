package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RodCutting {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc;
		BufferedReader br = Utils.getReader();
		tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] val = new int[n];
			String[] str = Utils.getTrimmed(br.readLine());
			for (int j = 0; j < n; j++) {
				val[j] = Integer.parseInt(str[j]);
			}

			int bestCost = rodCut(val, n);
			Utils.println(bestCost);
		}
	}

	private static int rodCut(int[] val, int n) {
		// TODO Auto-generated method stub
		int[] C = new int[n + 1];
		C[0] = 0;
		for (int i = 1; i <= n; i++) {
			C[i] = val[i - 1];
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				C[i] = Math.max(C[i], val[j] + C[i - (j + 1)]);
			}
		}
		return C[n];
	}
}
