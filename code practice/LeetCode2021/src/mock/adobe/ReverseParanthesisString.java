package mock.adobe;

import java.util.Stack;

public class ReverseParanthesisString {
    public static void main(String[] args) {
        System.out.print(new ReverseParanthesisString().reverseParentheses("yfgnxf)"));
    }

    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack();
        StringBuilder sb = new StringBuilder();
        int index = s.indexOf('(');
        int lastIndex = s.lastIndexOf(')');

        if(index == -1) return s;
        for (int i = index; i <= lastIndex; i++) {
            if (s.charAt(i) == ')') {
                sb.setLength(0);
                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();

                for (int j = 0; j < sb.length(); j++) {
                    st.push(sb.charAt(j));
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        StringBuilder finalString = new StringBuilder(s.substring(0, index) +sb.toString()+s.substring(lastIndex+1));
        return finalString.toString();
    }
}
