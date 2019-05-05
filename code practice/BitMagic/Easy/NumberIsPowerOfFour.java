package BitMagic;

/**
 * Find whether a given number is a power of 4 or not
 * @author g.bhardwaj
 *
 */
public class NumberIsPowerOfFour {
	public static void main(String[] args) {
		int no = 64;
		myWay(no);
		smartWay(no);
	}
	
	private static void smartWay(int n) {
		// TODO Auto-generated method stub
		int setBit = n&n-1;
		int countOfZeros = 0;
		if (n>0 && setBit == 0)  {//this checks if n has only one set bit.
			while(n > 1) {//this loops counts number of zeros
				n>>=1;
				countOfZeros++;
			}
			if(countOfZeros%2 == 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		} else {
			System.out.println("No");
		}
	}

	static void myWay(int no) {
		int setBit = 1;
		int countOfZeros = 0;
		boolean flag = true;
		while(no != 1) {
			if((setBit&no) == 0) {
				countOfZeros++;
			} else {
				flag = false;
				break;
			}
			no = no>>1;
		}
		
		if(!flag) {
			System.out.println("No");
		}
		
		if(countOfZeros != 0 && countOfZeros%2 == 0) {
			System.out.println("Yes");
		} else if(flag){
			System.out.println("No");
		}
	}
}

//Logic: A number is power of 4 if it has only set bit and numbe of zero bits in it are even.