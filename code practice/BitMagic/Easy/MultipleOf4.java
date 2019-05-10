package BitMagic;

public class MultipleOf4 {
	public static void main(String[] args) {
		int n = 101;
		isMultipleOf4UsingXOR(n);
		isMultipleOf4UsingShifting(n);
	}

	// Logic: if a number is divisible by 4 then its last two bits are always 0.
	// So first right shift and then left shift by 2 bits will result in same
	// number if its divisible by 4
	private static void isMultipleOf4UsingShifting(int n) {
		// TODO Auto-generated method stub
		if ((n >> 2) << 2 == n) {
			System.out.println("Shifting: Yes");
		} else {
			System.out.println("Shifing: No");
		}
	}

	// Logic: XOR of 1 to n-1 results in 0. So XOR of (1 to n-1) and n is same
	// as n
	private static void isMultipleOf4UsingXOR(int n) {
		// TODO Auto-generated method stub
		int xor = 0;
		for (int i = 1; i <= n; i++) {
			xor ^= i;
		}
		if (xor == n) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
