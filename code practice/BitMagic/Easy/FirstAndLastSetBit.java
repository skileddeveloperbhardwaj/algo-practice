package BitMagic;

/**
 * Print numbers having first and last bits as the only set bits Given a
 * positive integer n. The problem is to print numbers in the range 1 to n
 * having first and last bits as the only set bits.
 * 
 * @author g.bhardwaj
 *
 */
public class FirstAndLastSetBit {
	public static void main(String[] args) {
		int n = 10;
		boolean isFirstAndLastBitSet = isFirstAndLastBitSet(n);
		System.out.println(isFirstAndLastBitSet);
		isFirstAndLastBitSet = usingSingleAndOp(n);
		usingEfficientMethod(n);
	}

	// Logic: First find next power of 2 and then do of it with 1. It will give
	// the number with only first and last bit as 1
	private static void usingEfficientMethod(int n) {
		// TODO Auto-generated method stub
		int setBit = 1;
		System.out.println("Efficient Method:");
		System.out.println(setBit);
		while (true) {
			setBit = setBit << 1;
			int num = setBit ^ 1;
			if (num > n)
				break;
			System.out.println(num);

		}
	}

	// Logic: check if current number -1 is the power of two then only its first
	// and last bits are set.
	private static boolean usingSingleAndOp(int n) {
		// TODO Auto-generated method stub
		System.out.println("1");
		for (int i = 3; i < n; i++) {
			if (isPowerOf2(i - 1)) {
				System.out.println(i);
			}
		}
		return false;
	}

	private static boolean isPowerOf2(int i) {
		// TODO Auto-generated method stub
		int isPowerOf2 = i & (i - 1);
		return (isPowerOf2 == 0);
	}

	private static boolean isFirstAndLastBitSet(int n) {
		// TODO Auto-generated method stub
		int isFirstBitSet = n & 1;
		int isLastBitSet = 0;
		n = n >> 1;
		if (isFirstBitSet == 1) {
			while (n > 0) {
				isLastBitSet = n & 1;
				n = n >> 1;
			}
			if (isLastBitSet == 1) {
				return true;
			}
		}
		return false;
	}

}
