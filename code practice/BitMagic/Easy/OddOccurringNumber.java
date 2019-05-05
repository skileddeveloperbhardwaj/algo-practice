package BitMagic;

/**
 * Find the Number Occurring Odd Number of Times Given an array of positive
 * integers. All numbers occur even number of times except one number which
 * occurs odd number of times. Find the number in O(n) time & constant space.
 * 
 * @author g.bhardwaj
 *
 */
public class OddOccurringNumber {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 2, 3, 1, 3 };
		int n = 7;
		int num = getOddOccurringNum(arr, n);
		System.out.println("Odd occurring number is: " + num);
	}

	private static int getOddOccurringNum(int[] arr, int n) {
		// TODO Auto-generated method stub
		int num = 0;
		for (int i = 0; i < n; i++) {
			num ^= arr[i];
		}
		return num;
	}
}

// Logic: XOR of all elements will make even occurring numbers as 0 and the
// final value will be the number with odd occurrence.