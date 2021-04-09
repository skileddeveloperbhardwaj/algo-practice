package mediium;

public class SearchRotatedArray {

	public static void main(String[] args) {
		int[] nums = new int[] {1,3};
		System.out.println(new SearchRotatedArray().search(nums, 0));
	}
	public int search(int[] nums, int target) {
		int pivot = findPivot(nums, 0, nums.length-1);
		int l1 = 0, e1 = pivot - 1;
		int l2 = pivot, e2 = nums.length-1;
		int index;
		if (target < nums[l1]) {
			index = binarySearch(nums, target, l2, e2);
		} else {
			index = binarySearch(nums, target, l1, e1);
		}

		return index;
	}

	private int findPivot(int[] nums, int left, int right) {
		
		while(left<=right) {
		int pivot = (left + right) / 2;
		if (nums[pivot] > nums[pivot + 1]) {
			return pivot+1;
		} else if (nums[pivot] >= nums[left]) {
			left = pivot + 1;
		} else {
			right = pivot - 1;
		}
		}

		return -1;
	}

	private int binarySearch(int[] nums, int target, int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (target < nums[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return -1;

	}

}
