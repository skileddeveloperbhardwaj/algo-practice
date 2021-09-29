package mock.adobe;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.print(new SumOfTwoIntegers().addStrings("123", "11"));
    }

    public String addStrings(String num1, String num2) {
        int c = 0;
        int l1 = num1.length();
        int l2 = num2.length();
        int i, j;
        StringBuilder sum = new StringBuilder();
        for (i = l1 - 1, j = l2 - 1; i >= 0 && j >= 0; i--, j--) {
            int d1 = num1.charAt(i) -'0';
            int d2 = num2.charAt(j) -'0';
            int s = (d1 + d2 + c) % 10;
            c = (d1 + d2 + c) / 10;
            sum.append(s);
        }
        while (i >= 0) {
            int s = (num1.charAt(i)-'0') + c;
            c = s / 10;
            sum.append(s % 10);
            i--;
        }

        while (j >= 0) {
            int s = (num2.charAt(j) -'c') + c;
            c = s / 10;
            sum.append(s % 10);
            j--;
        }
        if (c != 0)
            sum.append(c);

        return sum.reverse().toString();
    }
}
