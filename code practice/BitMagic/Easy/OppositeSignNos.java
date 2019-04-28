package easy;

/**
 * Detect if two integers have opposite signs
 * 
 * @author Gaurav
 *
 */
public class OppositeSignNos {
	public static void main(String[] args) {
		int x = 100, y = -100;
		int res = x ^ y;
		if (res < 0) {
			System.out.println("Opposite signs!!");
		} else {
			System.out.println("Same signs!!");
		}
	}
}

//Logic: signed bit of negative number is 0 while that of positive number is 1. Hence, XOR of two opposite signs numbers is number with signed bit as 1.

//Output: Opposite Signs!!