import java.math.BigInteger;

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("",""));
    }

    public String multiply(String num1, String num2) {
        Long n1 = Long.parseLong(num1);
        Long n2 = Long.parseLong(num2);
        Long n3= n1*n2;
        return n3+"";
    }
}
