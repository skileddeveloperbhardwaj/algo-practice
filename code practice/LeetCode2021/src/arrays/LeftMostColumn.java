package arrays;

import java.util.List;

public class LeftMostColumn {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimen = binaryMatrix.dimensions();
        int m = dimen.get(0);
        int n = dimen.get(1);
        int smallest = n;

        for (int i = 0; i < m; i++) {
            int index = binarySearch(binaryMatrix, i, n, 0, n - 1);
            smallest = Math.min(smallest, index);
        }
        return smallest == n?-1:smallest;
    }

    private int binarySearch(BinaryMatrix arr, int row, int cols, int left, int right) {
        while (left < right) {
            int mid = (left+right)/2;
            if(arr.get(row, mid) == 0) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        if(arr.get(row, left) == 1) return left;
        return cols;
    }

    interface BinaryMatrix {
        public int get(int row, int col);

        public List<Integer> dimensions();
    }
}
