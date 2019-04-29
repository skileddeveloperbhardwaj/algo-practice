package BitMagic;

/**
 * Brian Kernighan’s Algorithm:
 * @author g.bhardwaj
 *
 */
public class CountSetBits {
	public static void main(String[] args) {
		int n = 31;
		int setBits = getCountSetBits(n);
		System.out.println("Number of set bits are: "+setBits);
	}

	private static int getCountSetBits(int n) {
		// TODO Auto-generated method stub
		int count = 0;
		while(n > 0) {
			n = n & n-1;
			count++;
		}
		return count;
	}
}
