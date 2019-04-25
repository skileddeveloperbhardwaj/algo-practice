package BitMagic;

import java.util.Scanner;

public class Parity {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int setBit = 1;
		int count = 0;
		while (n > 0) {
			if ((n & setBit) == 1) {
				count++;
			}
			n = n >> 1;
		}

		if ((count & 1) == 1)
			System.out.println("odd");
		else
			System.out.println("even");
	}

}
