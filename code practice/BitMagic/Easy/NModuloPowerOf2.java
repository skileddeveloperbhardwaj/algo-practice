package BitMagic;

/**
 * Compute modulus division by a power-of-2-number
 * 
 * @author g.bhardwaj
 *
 */
public class NModuloPowerOf2 {
	public static void main(String[] args) {
		int n = 10, d = 4;
		int modulo = getMywayModulo(n, d);
		System.out.println("My way Modulo is:" + modulo);
		modulo = getSmartWayModulo(n, d);
		System.out.println("Smart way Modulo is:" + modulo);
	}

	private static int getSmartWayModulo(int n, int d) {
		// TODO Auto-generated method stub
		return (n & (d - 1));
	}

	private static int getMywayModulo(int n, int d) {
		// TODO Auto-generated method stub
		int count = 0;
		int result = 0;
		while (d != 0) {
			count++;
			d = d >> 1;
		}

		int setBit = 1;
		for (int i = 0; i < (count - 1); i++) {
			result |= n & setBit;
			setBit = setBit << 1;
		}

		return result;
	}
}

// Logic Smart way: If d has k bits(inc 1) then k-1 bits from right in n is the
// modulo of n%d.