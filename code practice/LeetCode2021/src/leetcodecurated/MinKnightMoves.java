package leetcodecurated;

import java.beans.IntrospectionException;

public class MinKnightMoves {
    int X,Y;

    public static void main(String[] args) {
        System.out.print(new MinKnightMoves().minKnightMoves(5,5));
    }
    public int minKnightMoves(int x, int y) {
        X=x;
        Y=y;
        return helper(0,0,0);
    }

    private int helper(int x, int y, int cnt) {
        if(x == X && y==Y) return cnt;
        if(x>X || y>Y) return Integer.MAX_VALUE;
        if(x<0 || y<0) return Integer.MAX_VALUE;
        int a1 = helper(x+2,y+1,cnt+1);
        int a2 = helper(x+1,y+2,cnt+1);
        int a3 = helper(x-2,y+1,cnt+1);
        int a4 = helper(x-1,y+2,cnt+1);
        int a5 = helper(x-2,y-1,cnt+1);
        int a6 = helper(x-1,y-2,cnt+1);
        int a7=helper(x+1,y-2,cnt+1);
        int a8=helper(x+2,y-1,cnt+1);
        return Math.min(a1, Math.min(a2,Math.min(a3,Math.min(a4,Math.min(a5, Math.min(a6, Math.min(a7,a8)))))));
    }
}
