package mediium;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Gaurav
 * 
 *         A lucky number is an element of the matrix such that it is the
 *         minimum element in its row and maximum in its column.
 */

public class LuckyNumber {
	public static void main(String[] args) {

		int[][] matrix = new int[][] { 
			{ 1, 10, 4, 2 }, 
			{ 9, 3, 8, 7 }, 
			{ 15, 16, 17, 12 } 
			};
		LuckyNumber l = new LuckyNumber();
		List<Integer> list = l.luckyNumbers(matrix);
		
		for(Integer i:list) {
			System.out.println(i);
		}
	}

	public List<Integer> luckyNumbers(int[][] matrix) {
		List<Integer> l = new ArrayList<Integer>();
		int[] minInRow = new int[matrix.length];
		int[] maxInCol = new int[matrix[0].length];
		int n = 100001;
		int minRow = -1;
		int maxRow = Integer.MIN_VALUE;
        //min in row
		for(int i=0;i<matrix.length;i++) {
			minRow = matrix[i][0];
			int min = 100001*i+0;
        	for(int j=0;j<matrix[0].length;j++) {
        		if(minRow > matrix[i][j]) {
        			minRow = matrix[i][j];
        			min = 100001*i+j;
        		}
        	}
        	minInRow[0] = min; 
        }
		
		// max in col
		for (int j = 0; j < matrix[0].length; j++) {
			maxRow = matrix[0][j];
			int max = 100001 * j + 0;
			for (int i = 0; i < matrix.length; i++) {
				if (maxRow < matrix[i][j]) {
					maxRow = matrix[i][j];
					max = 100001 * i + j;
				}
			}
			maxInCol[0] = max;
		}
		
		for(int r = 0;r<matrix.length;r++) {
			int row = minInRow[r]/100001;
			int col = minInRow[r]%100001;
			for(int c = 0;c<matrix[0].length;c++) {
				int rc = maxInCol[c]/100001;
				int cc = maxInCol[c]%100001;
				if(row == rc && col == cc) {
					l.add(matrix[rc][cc]);
				}
			}
		}
		
		return l;
	}

}
