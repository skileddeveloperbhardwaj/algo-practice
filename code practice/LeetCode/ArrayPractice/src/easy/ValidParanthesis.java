package easy;

import java.util.*;

public class ValidParanthesis {
	
	public static void main(String[] args) {
		String str = "()";
		
		System.out.print(new ValidParanthesis().isValid(str));
		
	}
	
	   public boolean isValid(String s) {
	        HashMap<Character, Character> map = new HashMap<Character, Character>();
	        map.put(')','(');
	        map.put(']','[');
	        map.put('}','{');
	        
	        Stack<Character> st = new Stack<Character>();
	        st.push(s.charAt(0));
	        for(int i=1;i<s.length();i++) {
	            char c = s.charAt(i);
	            if(map.containsKey(c) && !st.isEmpty()) {
	            	char m = map.get(c);
	                char top = st.pop();
	                if(m!= top) {
	                	return false;
	                }
	            } else {
	                st.push(c);
	            }
	        }
	        
	            return st.isEmpty();
	    }

}
