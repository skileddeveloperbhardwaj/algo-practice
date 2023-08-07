public class TwoDMatrixSearch {
    public boolean searchMatrix(int[][] mat, int t) {
        int n = mat[0].length - 1;

        for (int i = 0; i < mat.length; i++) {
            if (mat[i][0] == t || mat[i][n] == t) return true;
            if (mat[i][0] < t && t < mat[i][n]) {
                return binarySearch(mat[i], t);
            }
        }

        return false;
    }

    private boolean binarySearch(int[] mat, int t) {
        int left = 0;
        int right = mat.length - 1;

        while (left <= right) {
            int mid = (left + right)/2;
            if (mat[mid] == t) return true;
            if(mat[mid] < t) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}