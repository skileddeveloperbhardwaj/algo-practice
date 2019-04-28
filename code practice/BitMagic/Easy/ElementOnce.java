package easy;

/**
 * Given an array where every element occurs three times, except one element
 * which occurs only once. Find the element that occurs once. Expected time
 * complexity is O(n) and O(1) extra space.
 * 
 * @author Gaurav
 *
 */
public class ElementOnce {
	static final int INT_SIZE = 32;

	// Method to find the element that occur only once
	static int getSingle(int arr[], int n) {
		int result = 0;
		int x;
		int sum;
		for (int i = 0; i < INT_SIZE; i++) {
			x = 1 << i;
			sum = 0;
			for (int j = 0; j < n; j++) {
				if ((arr[j] & x) == 0) {
					sum++;
				}
			}

			/*
			 * if sum is divisible by 3 then current bit is set for element whose occurrence
			 * is only once.
			 * 
			 */
			if (sum % 3 == 0) {
				result |= x;
			}
		}

		return result;
	}

	// Driver method
	public static void main(String args[]) {
		int arr[] = { 1, 1, 1, 2, 2, 2, 4, 3, 3, 3 };
		int n = arr.length;
		System.out.println("The element with single occurrence is " + getSingle(arr, n));
	}

}
