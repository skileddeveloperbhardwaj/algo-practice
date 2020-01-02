package easy;

public class RangeSumQuery {
	private int[] sum;
	private int[] mNums;

	public RangeSumQuery(int[] nums) {
		sum = new int[nums.length + 1];
		mNums = nums;
		updateSum();
	}

	public static void main(String[] args) {
		RangeSumQuery query = new RangeSumQuery(new int[] { -2, 0, 3, -5, 2, -1 });
		System.out.println(query.sumRangeByCache(2, 5));
	}

	// Brute Force
//	public int sumRange(int i, int j) {
//		int sum = 0;
//		for (int k = i; k <= j; k++) {
//			sum += mNums[k];
//		}
//
//		return sum;
//	}

	// Hashmap solution: by pre-computing pairwise sum and returning when query is
	// made
	/*
	 * public int sumRangeHash(int i, int j) {
	 * 
	 * }
	 */

	// Using caching

	/**
	 * Runtime: 9 ms, faster than 96.43% of Java online submissions for Range Sum
	 * Query - Immutable. Memory Usage: 40.1 MB, less than 100.00% of Java online
	 * submissions for Range Sum Query - Immutable.
	 * 
	 * sum[k] = sigma(num[0...k-1]){ both inclusive} sumRange(i,j) = sum[j+1] -
	 * sum[i]
	 */
	public int sumRangeByCache(int i, int j) {
		return (sum[j + 1] - sum[i]);
	}

	public void update(int i, int val) {
		mNums[i] = val;
		updateSum();

	}

	private void updateSum() {
		for (int i = 0; i < mNums.length; i++) {
			sum[i + 1] = sum[i] + mNums[i];
		}
	}

}
