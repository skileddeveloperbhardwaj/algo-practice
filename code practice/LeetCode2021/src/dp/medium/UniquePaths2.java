package dp.medium;

public class UniquePaths2 {
    public static void main(String[] args) {
        System.out.print(new UniquePaths2().uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = obstacleGrid[0][0]==1?0:1;
        //first row
        for (int j = 1; j < n; j++) {
            if(obstacleGrid[0][j] == 1) continue;
            dp[0][j] = dp[0][j-1];
        }

        //first column
        for(int i=1;i<m;i++) {
            if(obstacleGrid[i][0] == 1) continue;
            dp[i][0] = dp[i-1][0];
        }

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
