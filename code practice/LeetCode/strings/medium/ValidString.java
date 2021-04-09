package strings.medium;

import java.util.*;

//Problem LeetCode:1249
public class ValidString {

    public static void main(String[] args) {
        System.out.print(new ValidString().minRemoveToMakeValid("))(("));
    }
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack();
        Set<Integer> removedIndices = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    removedIndices.add(i);
                }
            }
        }

        while (!st.isEmpty()) removedIndices.add(st.pop());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(!removedIndices.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public String minRemoveToMakeValid2(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        // Put any indexes remaining on stack into the set.
        while (!stack.isEmpty())
            indexesToRemove.add(stack.pop());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
