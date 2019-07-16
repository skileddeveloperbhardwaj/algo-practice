package dp;

public class CoinChange {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		int m = arr.length;
		System.out.println(count(arr, m - 1, 4));
		System.out.println(countDP(arr, m , 4));
	}

	private static int count(int[] arr, int m, int s) {
		// TODO Auto-generated method stub
		if (s == 0)
			return 1;
		if (s < 0 || m < 0)
			return 0;

		// mth included + mth excluded
		return count(arr, m, s - arr[m]) + count(arr, m - 1, s);
	}

	// Dynamic Programming solution: this can be done using 2D as well
	public static int countDP(int[] arr, int m, int s) {
		int table[] = new int[s + 1];
		table[0] = 1;
        for(int i=0;i<m;i++) {
        	for(int j=arr[i];j<=s;j++) {
        		table[j]+=table[j-arr[i]];
        	}
        }
		return table[s];
	}
}
