package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FrogHops {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			int step = Integer.parseInt(br.readLine());
			int count = noOfWays(step);
			System.out.println(count);
		}

	}

	private static int noOfWays(int step) {
		// TODO Auto-generated method stub
		int count[] = new int[step + 1];
		count[0] = 1;
		count[1] = 1;
		if (step > 1) {
			count[2] = 2;
			for (int i = 3; i <= step; i++) {
				count[i] = count[i - 1] + count[i - 2] + count[i - 3];
			}
		}
		return count[step];
	}
}
