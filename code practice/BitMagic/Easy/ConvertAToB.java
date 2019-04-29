package BitMagic;

/**
 * Count number of bits to be flipped to convert A to B Given two numbers ‘a’
 * and b’. Write a program to count number of bits needed to be flipped to
 * convert ‘a’ to ‘b’.
 * 
 * @author g.bhardwaj
 *
 */
public class ConvertAToB {

	private static int INT_SIZE = 32;

	public static void main(String[] args) {
		int a = 10, b = 7;
		int bitsFlipped = getMyWayBitsFlipped(a, b);
		System.out.println("Number of bits flipped are(My way): " + bitsFlipped);
		bitsFlipped = smartWayGetBitsFlipped(a, b);
		System.out.println("Number of bits flipped are(smart way): " + bitsFlipped);
	}

	private static int smartWayGetBitsFlipped(int a, int b) {
		// TODO Auto-generated method stub
		int XORofAB = a ^ b;
		int setBit = 1;
		int count = 0;
		while (XORofAB > 0) {
			if ((XORofAB & setBit) == 1) {
				count++;
			}
			XORofAB = XORofAB >> 1;
		}
		return count;
	}

	private static int getMyWayBitsFlipped(int a, int b) {
		// TODO Auto-generated method stub
		int setBit = 1;
		int count = 0;
		for (int i = 0; i < INT_SIZE; i++) {
			boolean same = ((a & setBit) == (b & setBit));
			if (!same) {
				count++;
			}
			a = a >> 1;
			b = b >> 1;
		}
		return count;
	}
}

// Logic: Find XOR of two numbers and then return number of set bits in
// XOR(a,b). In XOR bits that are set are the different bits in a and b.
// [XOR(0,1) = XOR(1,0) = 1]