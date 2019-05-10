package BitMagic;

/**
 * How to turn off a particular bit in a number? Difficulty Level: Rookie
 * 
 * Given a number n and a value k, turn of the k’th bit in n.
 * 
 * @author g.bhardwaj
 *
 */
public class TurnOffK {
	public static void main(String[] args) {
		int n = 15;
		int k = 4;
		int newNo = turnOffKMyWay(2, 1);
		System.out.println(newNo);
		newNo = turnOffKUsingAnd(2, 1);
		System.out.println(newNo);
	}

	// Logic: XOR with 1 right shifted to one less than 'k'. Problem with this
	// logic is that if kth bit is already 0 then it will change it to 1, which
	// is not the expected result.
	private static int turnOffKMyWay(int n, int k) {
		// TODO Auto-generated method stub
		int onBit = 1;
		int no = n ^ (onBit << (k - 1));
		return no;
	}

	// Logic: First left shift 1 to k-1 bits then take bitwise NOT to it and
	// lastly apply bitwise AND between it and number. Bitwise NOT will convert
	// all bits to 1 except k-1 th bit.
	private static int turnOffKUsingAnd(int n, int k) {
		return n & ~(1 << (k - 1));
	}

}
