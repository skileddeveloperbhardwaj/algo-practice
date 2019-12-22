package easy;

public class BestTimeBuyAndSellStock {
	public static void main(String[] args) {
		int[] prices = new int[] {7,6,4,3,1};
		int maxProfit = getMaxProfit(prices);
		
		System.out.print(maxProfit);
	}

	private static int getMaxProfit(int[] prices) {
		int valley,peak;
		int i=0;
		int maxProfit = 0;
		while(i<prices.length-1) {
			//loop to find valley
			while(i<prices.length-1 && prices[i] >= prices[i+1])
				i++;
			valley = prices[i];
			
			//loop to find peak
			while(i<prices.length-1 && prices[i] <= prices[i+1]) 
				i++;
			peak = prices[i];
			
			maxProfit += peak - valley;
				
		}
		return maxProfit;
	}
}
