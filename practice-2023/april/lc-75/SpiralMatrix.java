import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean visited[][] = new boolean[m][n];
        int r = 0;
        int c = 0;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int d = 0;
        List<Integer> res = new ArrayList<>();

        for (int i=0;i<m*n;i++) {
            res.add(mat[r][c]);
            visited[r][c] = true;
            int currR = r + dir[d][0];
            int currC = c + dir[d][1];

            if (currR < m && currR >= 0 && currC >= 0 && currC < n && !visited[currR][currC]) {
                r = currR;
                c = currC;
            } else {
                d = (d+1)%4;
                r = r + dir[d][0];
                c = c + dir[d][1];
            }
        }

        return res;
    }
}
