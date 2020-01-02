package easy;

public class ClimbingStairsWays {

	public static void main(String[] args) {
		System.out.println(climbStairs(3));
		System.out.println(climbStairsFib(10));
	}

	public static int climbStairs(int n) {
		int dp[] = new int[n + 1];
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}

		return dp[n];
	}

	public static int climbStairsFib(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		int f1 = 1;
		int f2 = 2;

		for (int i = 3; i <= n; i++) {
			int f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}

		return f2;

	}

}
