package medium;

import java.util.Scanner;

public class MinDiff {

	public static void main(String[] args) {
		int tc;
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		for(int i=0;i<tc;i++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			int min = Integer.MAX_VALUE;
			for(int j=0;j<n;j++) {
				arr[j]=sc.nextInt();
			}
			
			//calculate min diff
			for(int k=1;k<n;k++) {
				for(int l=0;l<k;l++) {
					int diff = Math.abs(arr[k]-arr[l]);
					if(diff<min) {
						min=diff;
					}
				}
			}
			System.out.println(min);
		}
	}
}
