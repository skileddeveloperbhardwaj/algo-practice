package Amazon;

import java.util.Scanner;

public class CountTotalSetBits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc;
		tc = sc.nextInt();
		for(int i=0;i<tc;i++) {
			int n,count=1;
			n=sc.nextInt();
			for(int j=2;j<=n;j++) {
				count += setBits(j);
			}
			
			System.out.println(count);
		}
	}

	private static int setBits(int n) {
		// TODO Auto-generated method stub
		int count = 0;
		while(n != 0) {
			if((n & 1) == 1) {
				count++;
			}
			n = n>>1;
		}
		return count;
	}
}
