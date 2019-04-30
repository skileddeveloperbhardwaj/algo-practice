package BitMagic;

public class PowerOf2 {
	public static void main(String[] args) {
		int n = 0;
		boolean check = isPowerOf2(n);
		System.out.println(check);
	}

	private static boolean isPowerOf2(int n) {
		// TODO Auto-generated method stub
		int x = n&(n-1);
		return (x>0&&(x == 0));
	}
}

//Logic: n&n-1: gives value as 0 if its power of 2. x>0 is for n = 0.