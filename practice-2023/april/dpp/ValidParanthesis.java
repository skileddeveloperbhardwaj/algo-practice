import java.util.Stack;

public class ValidParanthesis {
    public boolean isValid(String s) {
        String closedP = ")]}";
        char[] chArr = s.toCharArray();
        Stack<Character> st = new Stack();

        for (char ch: chArr) {
            if (closedP.indexOf(ch) != -1) {
                if (!st.isEmpty() && ((ch == ')' && st.peek() =='(') || (ch == ']' && st.peek() == '[') || (ch == '}' && st.peek() == '{'))) {
                    st.pop();
                    continue;
                }
            }
            st.push(ch);
        }

        return st.isEmpty();
    }
}
