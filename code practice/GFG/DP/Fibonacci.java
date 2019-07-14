package dp;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		long fib[];
		int tc;
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int n = sc.nextInt();
			fib = new long[n];
			fib[0] = 1;
			System.out.print(fib[0]);
			if(n > 1) {
			fib[1] = 1;
			System.out.print(" " + fib[1]);
			for (int j = 2; j < n; j++) {
				fib[j] = fib[j - 1] + fib[j - 2];
				System.out.print(" " + fib[j]);
			}
			}
			System.out.println();
		}
	}

}
