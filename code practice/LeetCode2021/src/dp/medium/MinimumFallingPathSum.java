package dp.medium;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int mat[][] = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.print(new MinimumFallingPathSum().minFallingPathSum(mat));
    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=1;i<m;i++) {
            for(int j=0;j<n;j++) {
                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;
                int c = Integer.MAX_VALUE;

                if(isValid(i-1,j, m, n)) a = matrix[i-1][j];
                if(isValid(i-1,j+1,m,n)) b = matrix[i-1][j+1];
                if(isValid(i-1, j-1,m,n)) c = matrix[i-1][j-1];

                matrix[i][j] +=Math.min(a,Math.min(b,c));
            }
        }

        //find min in last row
        int min = matrix[m - 1][0];
        for (int j = 1; j < n; j++) {
            if (matrix[m-1][j] < min) {
                min = matrix[m-1][j];
            }
        }

        return min;
    }

    private boolean isValid(int i, int j, int m, int n) {
        if(i>=0 && i<m && j>=0 && j<n) return true;
        return false;
    }
}
