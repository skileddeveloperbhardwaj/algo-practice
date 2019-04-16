package medium;

public class PalindromicArray {
	/*
	 * To find minimum number of operations to make an array a palindrome.
	 * Only merge operation is allowed.
	 */
	
	static int findMinOps(int[] arr, int n) {
		int ans = 0;
		
		for(int i = 0,j=n-1;i<=j;) {
			if(arr[i] == arr[j]) {
				i++;
				j--;
			} else if(arr[i] > arr[j]) {//merge from end
				ans++;
				arr[j-1] += arr[j];
				j--;
			} else { //merge from beginning
				ans++;
				arr[i+1] += arr[i];
				i++;
			}
		}
		return ans;
	}
	
	 // Driver method to test the above function 
    public static void main(String[] args) 
    { 
        int arr[] = new int[]{1, 5, 5, 1} ; 
        System.out.println("Count of minimum operations is "+ 
                                findMinOps(arr, arr.length)); 
      
    }

}
