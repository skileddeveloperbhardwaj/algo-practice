package medium;

public class EditDistance {
//    public int editDistance(String s, String t) {
//        // Code here
//        return editDistanceHelper(s, t, s.length(), t.length());
//    }

    public int editDistance(String s, String t) {
        // Code here
        int rows = s.length() + 1;
        int cols = t.length() + 1;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0) dp[0][j] = j;
                if (j == 0) dp[i][0] = i;

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]);
                }
            }
        }

        return dp[rows][cols];
    }

    private int editDistanceHelper(String s, String t, int m, int n) {
        if (m == 0) return n;
        if (n == 0) return m;

        if (s.charAt(m - 1) == t.charAt(n - 1)) {
            return editDistanceHelper(s, t, m - 1, n - 1);
        }

        return 1 + Math.min(Math.min(editDistanceHelper(s, t, m, n - 1),
                editDistanceHelper(s, t, m - 1, n)),
                editDistanceHelper(s, t, m - 1, n - 1));

    }

}
