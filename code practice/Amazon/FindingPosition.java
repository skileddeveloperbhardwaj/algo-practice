package Amazon;

import java.util.Scanner;

public class FindingPosition {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int tc = sc.nextInt();
		int n;
		for(int i = 0;i<tc;i++) {
			n = sc.nextInt();
			int pos = findPos(n);
			System.out.println(pos);
		}
		
	}

	private static int findPos(int n) {
		// TODO Auto-generated method stub
		int p = (int)(Math.log(n)/Math.log(2));
		return (int) Math.pow(2, p);
	}

}
