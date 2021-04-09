package strings.easy;

public class AddStrings {

    //"3876620623801494171"
    //"6529364523802684779"
    public static void main(String[] args) {
        String sum = new AddStrings().addStrings("11", "123");
        System.out.print(sum);
    }

    public String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        String finalSum = "";
        int rem = 0;
        int i, j;
        for (i = l1, j = l2; i >= 0 && j >= 0; i--, j--) {
            int digit = Integer.parseInt(num1.charAt(i) + "") +
                    Integer.parseInt(num2.charAt(j) + "") + rem;
            rem = digit / 10;
            finalSum = digit % 10 + finalSum;
        }

        while (i >= 0) {
            int digit = Integer.parseInt(num1.charAt(i--) + "") + rem;
            rem = digit / 10;
            finalSum = digit % 10 + finalSum;
        }

        while (j >= 0) {
            int digit = Integer.parseInt(num2.charAt(j--) + "") + rem;
            rem = digit / 10;
            finalSum = digit % 10 + finalSum;
        }
        if (rem != 0) finalSum = rem + finalSum;
        return finalSum;

    }
}
