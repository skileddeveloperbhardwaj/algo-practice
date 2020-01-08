package medium;

public class DeleteAndEarn {
	public static int deleteAndEarn(int[] nums) {
		int prev = -1;
		int avoid = 0, using = 0;
		int[] count = new int[10001];
		for (int i = 0; i < nums.length; i++) {
			count[nums[i]]++;
		}

		for (int k = 0; k <= 10000; k++) {
			if (count[k] > 0) {
				int m = Math.max(avoid, using);
				if (k - 1 == prev) {
					using = count[k] * k + avoid;
				} else {
					using = count[k] * k + m;
				}
				avoid = m;
				prev = k;
			}
		}

		return Math.max(avoid, using);

	}

	public static void main(String[] args) {
		System.out.print(deleteAndEarn(new int[] {3, 4, 2}));

	}
}
