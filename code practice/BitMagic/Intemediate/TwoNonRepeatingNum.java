package BitMagic;

import java.util.Scanner;

public class TwoNonRepeatingNum {
	public static void main(String[] args) {
		int n, xor = 0;
		int setBit = 0;
		int x = 0, y = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		//calculates XOR of all elements. value after this will be the XOR of two non-repeating elements
		for (int i = 0; i < n; i++) {
			xor ^= arr[i];
		}

		//finds the rightmost set bit in the xor variable
		setBit = xor & ~(xor - 1);

		//this loop divides two non-repeating elements from xor into x and y.
		//Mechanism: in xor var if a bit is set then corresponding bit will be 0 and 1 in two non-repeating elements.
		//and if a bit is 0 in cor var then it will same in x & y. So we have taken a rightmost set bit in xor and then did
		//XOR op with all elements in arr. So if & operation of setBit and arr[i] is zero then it corresponds to x otherwise y.
		//At the end all same elements' XOR will be 0 and whatever left in x & y are two non-repeating elements.
		for (int i = 0; i < n; i++) {
			if ((setBit & arr[i]) != 0) {
				x = x ^ arr[i];
			} else {
				y = y ^ arr[i];
			}
		}
		
		System.out.println("Two non repeating numbers are:"+x+" & "+y);
	}

}
