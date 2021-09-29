package javapractice.lambda;

interface Calculator {
//    int calculate(int x, int y);
    default void show() {
        System.out.println("show");
    }
}

public class LambdaPractice implements Calculator{
    private int factor = 10;

    public static void main(String[] args) {
//        Calculator sum = (a,b)->a*new LambdaPractice().factor+b;
//        System.out.println(sum.calculate(3,4));
//
//        Calculator mul = (a,b)->(a*b);
//        System.out.println(mul.calculate(3,4));
    }

    public void show() {
        Calculator.super.show();
    }
}
