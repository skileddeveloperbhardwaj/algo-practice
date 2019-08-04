import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UnboundedKnapSack01 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			String line = br.readLine();
			String[] strs = line.trim().split("\\s+");
			int n = Integer.parseInt(strs[0]);
			int W = Integer.parseInt(strs[1]);

			int[] val = new int[n];
			line = br.readLine();
			strs = line.trim().split("\\s+");
			for (int j = 0; j < n; j++) {
				val[j] = Integer.parseInt(strs[j]);
			}

			int[] wt = new int[n];
			line = br.readLine();
			strs = line.trim().split("\\s+");
			for (int j = 0; j < n; j++) {
				wt[j] = Integer.parseInt(strs[j]);
			}

			int value = unboundedKnapSack(val, wt, n, W);
			System.out.println(value);
		}
	}

	private static int unboundedKnapSack(int[] val, int[] wt, int n, int W) {
		// TODO Auto-generated method stub
		int[] dp = new int[W + 1];
		Arrays.fill(dp, 0);
		for (int i = 0; i <= W; i++) {
			for (int j = 0; j < n; j++) {
				if (wt[j] <= i) {
					dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
				}
			}
		}
		return dp[W];
	}

}
