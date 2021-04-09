package strings.medium;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String str = new DecodeString().decodeString("3[a]2[bc]");
        System.out.print(str);
    }
    public String decodeString(String s) {
        String decodedString = "";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                decodedString = "";
                while (st.peek() != '[') {
                    decodedString += st.pop();
                }
                st.pop();
                int k = 0;
                int base = 1;
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    k += (st.pop() - '0') * base;
                    base *=10;
                }

                while(k !=0) {
                    for(int j=decodedString.length()-1;j>=0;j--) {
                        st.push(decodedString.charAt(j));
                    }
                    k--;
                }
            } else {
                st.push(s.charAt(i));
            }
        }

        int len = st.size();
        char[] ch = new char[len];
        for(int i=len-1;i>=0;i--) {
            ch[i] = st.pop();
        }

        return new String(ch);
    }
}
