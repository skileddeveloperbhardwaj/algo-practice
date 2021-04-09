package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list = new LetterCombination().letterCombinations("234");
        for (String s : list) {
            System.out.print(s + ", ");
        }
    }

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        backtrack("", digits);
        return output;
    }

    private void backtrack(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            output.add(combination);
        } else {
            String numbers = phone.get(nextDigits.substring(0, 1));
            for (int i = 0; i < numbers.length(); i++) {
                String letter = numbers.substring(i,i+1);
                backtrack(combination+letter, nextDigits.substring(1));
            }
        }
    }

    /*
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5',"jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        if(digits.length() == 0) return new ArrayList<>();
        if(digits.length() == 1) {
            List<String> list = new ArrayList();
            String str = map.get(digits.charAt(0));
            for(int i=0;i<str.length();i++) {
                list.add(str.charAt(i)+"");
            }
            return list;
        }

        char c1 = digits.charAt(0);
        String s1 = map.get(c1);
        char c2 = digits.charAt(1);
        String s2 = map.get(c2);
        List<String> list = new ArrayList<>();
        for(int i=0;i<s1.length();i++) {
            for(int j=0;j<s2.length();j++) {
                String str = s1.charAt(i)+""+s2.charAt(j)+"";
                list.add(str);
            }
        }

        if(digits.length() == 2) {
            return list;
        }

        String s3 = map.get(digits.charAt(2));
        int size = list.size();
        List<String> list2 = new ArrayList<>();
        for(int i=0;i<size;i++) {
            for(int j=0;j<s3.length();j++) {
                String str = list.get(i)+s3.charAt(j);
                list2.add(str);
            }
        }

        if(digits.length() == 3) {
            return list2;
        }

        String s4 = map.get(digits.charAt(3));
        size = list2.size();
        List<String> list3 = new ArrayList<>();
        for(int i=0;i<size;i++) {
            for(int j=0;j<s4.length();j++) {
                String str = list2.get(i)+s4.charAt(j);
                list3.add(str);
            }
        }

        return list3;
    }*/
}
