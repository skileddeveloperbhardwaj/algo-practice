public class Driver {
    public static void main(String[] args) {
//        System.out.println(new HappyNumber().isHappy(19));
//        System.out.println(new HappyNumber().isHappy(7));
        System.out.println(new ValidParanthesis().isValid("()"));
        System.out.println(new ValidParanthesis().isValid("(]"));
        System.out.println(new ValidParanthesis().isValid("]"));
    }
}
