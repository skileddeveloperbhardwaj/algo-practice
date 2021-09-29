package javapractice;

public class Test {
    public static void main(String[] args) {
        String str ="abc";
        String str1 = new String("abc");

        System.out.print(str.equals(str1));
    }
}

enum Color {
    RED, GREEN, BLUE;
    Color(){}
}
