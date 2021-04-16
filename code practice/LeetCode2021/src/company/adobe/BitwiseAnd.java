package company.adobe;

public class BitwiseAnd {
    public static void main(String[] args) {
         System.out.print(new BitwiseAnd().rangeBitwiseAnd(5,7));
    }

    public int rangeBitwiseAnd(int left, int right) {
        int and = 1;
        for(int i=left;i<=right;i++) {
            and = and & i;
        }
        return and;
    }
}
