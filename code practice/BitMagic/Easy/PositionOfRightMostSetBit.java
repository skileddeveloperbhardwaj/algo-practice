package BitMagic;

public class PositionOfRightMostSetBit {
	public static void main(String[] args) {
		int n = 18;
		int pos = getPosRightMostBit(n);
		System.out.println(pos);
	}

	private static int getPosRightMostBit(int n) {
		// TODO Auto-generated method stub
		int setBit = 1;
		int count = 0;
		while (n>0) {
			count++;
			if ((n & setBit) == 1) {
				break;
			}
			n=n>>1;
		}
		return count;
	}
}
