public class RotateImage {
    public static void main(String[] args) {
        int[][] m = {{5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        new RotateImage().rotateImage(m);

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void rotateImage(int[][] m) {
        int len = m.length;
        int k = len - 1;
        for (int i = 0; i < (len + 1) / 2; i++) {
            for (int j = 0; j < (len / 2); j++) {
                int temp = m[k - j][i];
                m[k - j][i] = m[k - i][k - j];
                m[k - i][k - j] = m[j][k - i];
                m[j][k - i] = m[i][j];
                m[i][j] = temp;
            }
        }
    }
}
