package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KnapSack0And1 {
	public static void main(String[] args) throws IOException {
		int tc;
//		Scanner sc = new Scanner(System.in);
//		tc = sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());;//sc.nextInt();
			int W = Integer.parseInt(br.readLine());//sc.nextInt();
			int wt[] = new int[n];
			int val[] = new int[n];

//			for (int j = 0; j < n; j++) {
//				val[j] = sc.nextInt();
//			}
			String line = br.readLine(); 
			String[] strs = line.trim().split("\\s+"); 

			for (int j = 0; j < n; j++) {
				val[j] = Integer.parseInt(strs[j]);//sc.nextInt();
			}
			
			line = br.readLine(); 
			strs = line.trim().split("\\s+");
			for (int j = 0; j < n; j++) {
				wt[j] = Integer.parseInt(strs[j]);//sc.nextInt();
			}
//			int value = KnapSack(val,wt,n,W);
			int value = KnapSackDP(val,wt,n,W);
			System.out.println(value);
		}
	}

	private static int KnapSackDP(int[] val, int[] wt, int n, int W) {
		// TODO Auto-generated method stub
		int[][] K = new int[n+1][W+1];
		for(int i = 0;i<=n;i++) {
			for(int j=0;j<=W;j++) {
				if(i == 0 || j==0) {
					K[i][j] = 0;
				} else if(wt[i-1] < j){
					K[i][j] = Math.max(K[i-1][j],val[i-1]+K[i-1][j-wt[i-1]]);
				} else {
					K[i][j] = K[i-1][j];
				}
			}
		}
		
		return K[n][W];
	}

	private static int KnapSack(int[] val, int[] wt, int n, int W) {
		// TODO Auto-generated method stub
		if(n==0 || W==0) {
			return 0;
		}
		if(wt[n-1] > W) {
			return KnapSack(val, wt, n-1, W);
		}
		return Math.max(KnapSack(val, wt, n-1, W),val[n-1]+KnapSack(val, wt, n-1, W-wt[n-1]));
	}

}
