package BitMagic;

/**
 * Rotate bits of a number Bit Rotation: A rotation (or circular shift) is an
 * operation similar to shift except that the bits that fall off at one end are
 * put back to the other end. In left rotation, the bits that fall off at left
 * end are put back at right end.
 * 
 * In right rotation, the bits that fall off at right end are put back at left
 * end.
 * 
 * @author g.bhardwaj
 *
 */
public class CircularRotation {

	private static int INT_SIZE = 32;

	public static void main(String[] args) {
		int n = 16;
		int d = 2;
		int left = leftRotate(n, d);
		int right = rightRotate(n, d);
		System.out.println("Left rotation is: " + left);
		System.out.println("Right rotation is: " + right);
	}

	private static int rightRotate(int n, int d) {
		// TODO Auto-generated method stub
		return (n >> d | n << (INT_SIZE - d));
	}

	private static int leftRotate(int n, int d) {
		// TODO Auto-generated method stub
		return (n << d | n >> (INT_SIZE - d));
	}
}
