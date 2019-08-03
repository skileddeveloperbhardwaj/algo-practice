package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSumIncrSub {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc;
		tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String line = br.readLine(); 
			String[] strs = line.trim().split("\\s+"); 
            for(int j=0;j<n;j++) {
            	arr[j] = Integer.parseInt(strs[j]);
            }
            
            int sum = maxSum(arr,n);
            System.out.println(sum);
		}
	}

	private static int maxSum(int[] arr, int n) {
		// TODO Auto-generated method stub
		int S[] = new int[n];
		for(int i=0;i<n;i++) {
			S[i] = arr[i];
		}
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i] > arr[j] && S[i] < (arr[i]+S[j])) {
					S[i] = arr[i]+S[j];
				}
			}
		}
		int max = S[0];
		for(int i=1;i<n;i++) {
			if(S[i] > max) {
				max = S[i];
			}
		}
		return max;
	}

}
