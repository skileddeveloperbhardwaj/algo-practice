package arrays;

import java.util.HashMap;
import java.util.Map;

public class SummationOfToWords {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        char ch = 'a';
        int k = 0;
        while(ch != 'j') {
            map.put(ch,k++);
            ch = (char)(ch+1);
        }

        String str= "acb";
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++) {
            sb.append(map.get(str.charAt(i)));
        }
        System.out.println(Integer.parseInt(sb.toString()));
        String str1= "cba";
        StringBuilder sb1=new StringBuilder();
        for(int i=0;i<str1.length();i++) {
            sb1.append(map.get(str1.charAt(i)));
        }
        System.out.println(Integer.parseInt(sb1.toString()));
        int sum = Integer.parseInt(sb.toString()) + Integer.parseInt(sb1.toString());
        System.out.println(sum);
    }
}
