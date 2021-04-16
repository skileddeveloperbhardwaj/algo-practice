package dp.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleSum {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList arr = new ArrayList();
        arr.add(-1);
        list.add(arr);
        ArrayList arr1 = new ArrayList();
        arr1.add(2);
        arr1.add(3);
        list.add(arr1);
        ArrayList arr2 = new ArrayList();
        arr2.add(1);
        arr2.add(-1);
        arr2.add(-3);
        list.add(arr2);
//        ArrayList arr3 = new ArrayList();
//        arr3.add(4);
//        arr3.add(1);
//        arr3.add(8);
//        arr3.add(3);
//        list.add(arr3);
        System.out.print(new TriangleSum().minimumTotal(list));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for(int[] row: dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[i][j] = list.get(j);
            }
        }

        for(int i=1;i<triangle.size();i++) {
            dp[i][0] +=dp[i-1][0];
        }

        for(int i=1;i<triangle.size();i++) {
            for(int j=1;j<triangle.get(i).size();j++) {
                dp[i][j] += Math.min(dp[i-1][j], dp[i-1][j-1]);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<m;j++) {
            if(dp[m-1][j] < min) {
                min = dp[m-1][j];
            }
        }
        return min;
    }
}
