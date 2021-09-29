package hackerrank.array;

public class CountingValleys {
    public static void main(String[] args) {
        System.out.print(CountingValleys.countingValleys(8, "UDDDUDUU"));
    }

    public static int countingValleys(int steps, String path) {
        int[] dp = new int[steps + 1];
        dp[0] = 0;
        for (int i = 0, j = 1; i < path.length(); i++) {
            if (path.charAt(i) == 'U') {
                dp[j] = dp[j - 1] + 1;
            } else {
                dp[j] = dp[j - 1] - 1;
            }
            j++;
        }
        int count = 0;

        if (dp[1] < 0) count++;
        for (int i = 1; i < steps; i++) {
            if (dp[i] == 0) {
                if ((dp[i - 1] > 0 && dp[i + 1] < 0) ||
                        (dp[i - 1] < 0 && dp[i + 1] < 0)) {
                    count++;
                }
            }
        }
        return count;
    }
}
