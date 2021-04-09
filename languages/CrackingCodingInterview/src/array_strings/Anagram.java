package array_strings;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        boolean b = new Anagram().isAnagram("listen", "silent");
        System.out.println(b);
    }

    boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

//        char[] temp1 = s1.toCharArray();
//        Arrays.sort(temp1);
//        char[] temp2 = s2.toCharArray();
//        Arrays.sort(temp2);
//        int[] arr = new int[128];

//        for(int i=0;i<temp1.length;i++) {
////            arr[temp1[i]-'a']++;
////            arr[temp2[i]-'a']--;
//            if(temp1[i] != temp2[i]) {
//                return false;
//            }
//        }

//        for(int i=0;i<128;i++) {
//            if(arr[i] !=0) {
//                return false;
//            }
//        }
        String str1 = sort(s1);
        String str2 = sort(s2);
        return str1.equals(str2);
    }

    private String sort(String s) {
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
}
