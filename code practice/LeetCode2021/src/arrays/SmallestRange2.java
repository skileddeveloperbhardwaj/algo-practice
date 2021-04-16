package arrays;

import java.util.Arrays;

/**
 * Adobe
 */
public class SmallestRange2 {
    public static void main(String[] args) {
        System.out.print(new SmallestRange2().smallestRangeII(new int[]{0,10},2));
    }
    public int smallestRangeII(int[] a, int k) {
        if (a.length == 0 || a.length == 1) return 0;
        Arrays.sort(a);
        int len = a.length;
        int ans = a[len-1] - a[0];
        for(int i = 0;i<a.length-1;i++) {
            int high = Math.max(a[i]+k,a[len-1]-k);
            int low = Math.min(a[0]+k, a[i+1]-k);
            ans = Math.min(high-low, ans);
        }
        return ans;
    }
}
