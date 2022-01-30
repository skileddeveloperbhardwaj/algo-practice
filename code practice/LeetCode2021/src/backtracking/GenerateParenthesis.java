package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        for(String s:list) {
            System.out.println(s);
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            backtrack(ans, cur.append("("), open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            backtrack(ans, cur.append(")"), open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
