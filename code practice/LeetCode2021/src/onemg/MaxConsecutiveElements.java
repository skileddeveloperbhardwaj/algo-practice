package onemg;

public class MaxConsecutiveElements {

    int maxCount =0;
    int count =0;
    int R,C;

    public int getMaxCount(int[][] arr) {
        R = arr.length;
        C = arr[0].length;
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                count = 0;
                dfs(arr, i,j,arr[i][j]);
                maxCount = maxCount>count?maxCount:count;
            }
        }

        return maxCount;
    }

    private void dfs(int[][] arr, int i, int j, int val) {
        if(i<0 || j<0 || i>=R || j>=C) {
            return;
        }

        if(check(i+1,j) && arr[i+1][j] == val+1) {
            count++;
            dfs(arr, i+1, j, val+1);
        }
        if(check(i-1,j) && arr[i+1][j] == val+1) {
            count++;
            dfs(arr, i-1, j, val+1);
        }
        if(check(i,j+1) && arr[i+1][j] == val+1) {
            count++;
            dfs(arr, i, j+1, val+1);
        }
        if(check(i,j-1) && arr[i][j-1] == val+1) {
            count++;
            dfs(arr, i, j-1, val+1);
        }
    }

    private boolean check(int i, int j) {
        if(i>=0 && j>=0 && i<R && j<C) {
            return true;
        }
        return false;
    }
}
