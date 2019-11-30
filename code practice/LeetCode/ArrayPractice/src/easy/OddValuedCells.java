package easy;

public class OddValuedCells {
	
	public static void main(String[] args) {
		int n=2,m=3;
		int[][] indices = {
				{0,1},
				{1,1}
		};
		
		int count = oddCells(n,m,indices);
		System.out.println("Count of odd cells is: "+count);
	}

	public static int oddCells(int n, int m, int[][] indices) {
		int count = 0;
		int size = indices.length;
		int arr[][] = new int[n][m];
		
		for(int i=0;i<size;i++) {
			incrMat(arr,m,indices[i][0],true);
			incrMat(arr,n,indices[i][1],false);
		}
		
		//check count of odd cells
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]%2 !=0) {
					count++;
				}
			}
		}

		return count;
	}

	private static void incrMat(int[][] arr,int j, int i, boolean isRow) {
		// TODO Auto-generated method stub
		if(isRow) {
			for(int k=0;k<j;k++) {
				arr[i][k]++;
			}
		} else {
			for(int k=0;k<j;k++) {
				arr[k][i]++;
			}
		}
	}

}
