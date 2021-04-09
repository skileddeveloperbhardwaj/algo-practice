package hard;

public class EditDistance {
	public static void main(String[] args) {
		EditDistance dist = new EditDistance();
		String word1 = "", word2 = "a";
		int minDis = dist.minDistance(word1, word2);
		System.out.println(minDis);
	}

	public int minDistance(String word1, String word2) {
		int l1 = word1.length();
		int l2 = word2.length();
		int[][] d = new int[l1+1][l2+1];
		
		//if l2 = 0 then ans is always l1
		for(int i=0;i<=l1;i++) {
			d[i][0] = i;
		}
		
		//if l1 is 0 then answer is always l2
		for(int j=0;j<=l2;j++) {
			d[0][j] = j;
		}
		
		for(int i=1;i<=l1;i++) {
			for(int j=1;j<=l2;j++) {
				int c = (word1.charAt(i-1) == word2.charAt(j-1))?0:1;
				d[i][j] = Math.min(c+d[i-1][j-1], 
						1+Math.min(d[i-1][j], d[i][j-1]));
			}
		}
		
		return d[l1][l2];

	}

}
