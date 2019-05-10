package BitMagic;

/**
 * Given a number, the task is to find XOR of count of 0s and count of 1s in
 * binary representation of a given number.
 * 
 * @author g.bhardwaj
 *
 */
public class CountXOR {
	public static void main(String[] args) {
		int n = 31;
		System.out.println(countXOR(n));
	}

	private static int countXOR(int n) {
		// TODO Auto-generated method stub
		int count0 = 0;
		int count1 = 0;

		while (n > 0) {
			if (n % 2 == 0) {
				count0++;
			} else {
				count1++;
			}
			n /= 2;
		}
		return count0 ^ count1;
	}

}
