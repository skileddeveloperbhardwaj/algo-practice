package dp;

import java.util.Scanner;

public class Min_Sum_Coins {

	public static void main(String[] args) {
		int tc;
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		int deno[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000} ;
		for(int i=0;i<tc;i++) {
			int sum = sc.nextInt();
			int min_val = minCoins(sum, deno);
			System.out.println(min_val);
		}
	}

	private static int minCoins(int sum, int[] deno) {
		// TODO Auto-generated method stub
		int C[] = new int[sum+1];
		C[0] = 0;
		for(int i=1;i<sum+1;i++)
			C[i] = Integer.MAX_VALUE;
		for(int i=1;i<=sum;i++) {
			for(int j=0;j<10;j++) {
				if(deno[j] <= i) {
					int res = C[i-deno[j]];
					if(res != Integer.MAX_VALUE && 1+res < C[i]) {
						C[i] = 1+res;
					}
				}
			}
		}
		return C[sum];
	}
}
