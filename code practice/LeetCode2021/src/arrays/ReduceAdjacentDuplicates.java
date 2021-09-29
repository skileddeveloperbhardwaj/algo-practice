package arrays;

import java.util.Stack;

public class ReduceAdjacentDuplicates {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<sb.length();i++) {
            if(i==0||sb.charAt(i) != sb.charAt(i-1)) {
                st.push(1);
            } else {
                int incremented = st.pop()+1;
                if(incremented == k) {
                    sb.delete(i-k+1, i+1);
                    i=i-k;
                } else {
                    st.push(incremented);
                }
            }
        }
        return sb.toString();
    }
}
