package mediium;

public class MostWaterContainer {

	public static void main(String[] args) {
		System.out.print(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
		System.out.print(maxAreaTwoPointer(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

	public static int maxArea(int[] height) {
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int len = j - i;
				int br = Math.min(height[i], height[j]);
				maxArea = Math.max(maxArea, len * br);
			}
		}

		return maxArea;

	}

	// Two pointer approach
	public static int maxAreaTwoPointer(int[] height) {
		int maxArea = 0;
		int left = 0, right = height.length - 1;

		while (left < right) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;

	}

}
