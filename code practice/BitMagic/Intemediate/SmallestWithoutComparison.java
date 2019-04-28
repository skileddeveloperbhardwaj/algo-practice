package BitMagic;

import java.util.Scanner;

public class SmallestWithoutComparison {
	public static void main(String[] args) {
		int x,y,z;
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		z = sc.nextInt();
		repeatedSubtraction(x,y,z);
		System.out.println(smallest(x,y,z));
	}

	private static void repeatedSubtraction(int x, int y, int z) {
		// TODO Auto-generated method stub
		int ctr = 0;
		while(x !=0 && y != 0 && z != 0) {
			x--;
			y--;
			z--;
			ctr++;
		}
		
		System.out.print(ctr);
	}

	private static int smallest(int x, int y, int z) { 
        if ((y / x) <= 1) // Same as "if (y < x)" 
            return ((y / z) <= 1) ? y : z; 
        return ((x / z) <= 1) ? x : z; 
    } 
}
