package hackerrank.array;

import java.util.ArrayList;
import java.util.List;

public class Array2D {
    public static void main(String[] args) {
        int[][] ar = new int[][]{
                {1, 1 ,1 ,0 ,0 ,0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0 ,0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        List<List<Integer>> arr = new ArrayList<>();
        for(int i=0;i<6;i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<6;j++) {
                list.add(ar[i][j]);
            }
            arr.add(list);
        }
        System.out.print(Array2D.hourglassSum(arr));
    }
    public static int hourglassSum(List<List<Integer>> arr) {
        int max = Integer.MIN_VALUE;
        int rows = arr.size();
        int cols = arr.get(0).size();
        for(int i=1;i<rows-1;i++) {
            for(int j=1;j<cols-1;j++) {
                int hourGlass = getHourGlassValue(arr, i,j);
                max = max>hourGlass?max:hourGlass;
            }
        }
        return max;
    }

    private static int getHourGlassValue(List<List<Integer>> arr, int i, int j) {
        int sum = arr.get(i).get(j);
        int[] top = new int[]{-1,0,1};
        for(int k=0;k<3;k++) {
            sum += arr.get(i-1).get(j+top[k])+arr.get(i+1).get(j+top[k]);
        }
        return sum;
    }
}
