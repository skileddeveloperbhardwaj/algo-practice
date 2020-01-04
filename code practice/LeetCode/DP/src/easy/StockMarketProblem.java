package easy;

public class StockMarketProblem {

	// My mess :(
//	public static int maxProfit(int[] prices) {
//		int maxProfit = 0;
//		int len = prices.length;
//		int l = 0;
//		int r = prices.length - 1;
//		int CP = prices[l];
//		int SP = prices[r];
//		l++;
//		r--;
//		int currMin = 0;
//		int currMan = len;
//		for (; l > len && r >= 0; l++, r--) {
//
//			// global minima
//			if (prices[l] < prices[l - 1]) {
//				CP = prices[l];
//			}
//
//			if (prices[r] > prices[r + 1]) {
//				SP = prices[r];
//			}
////			r--;
////			l++;
//		}
//
//		return SP - CP;
//	}

	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else if (prices[i] - minPrice > maxProfit) {
				maxProfit = prices[i] - minPrice;
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));

	}

}
