package array_strings;

import java.util.Arrays;

public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(new PalindromePermutation().isPalPermutation("tactcooa"));

    }

    public boolean isPalPermutation(String str) {
        int[] temp = new int[256];
        int c = 0;
        Arrays.fill(temp, 0);
        for (int i = 0; i < str.length(); i++) {
            if (temp[str.charAt(i) - 'a'] != 0) {
                temp[str.charAt(i) - 'a']--;
            } else {
                temp[str.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < 256; i++) {
            if(temp[i] != 0) {
                c++;
            }
        }

        if(str.length()%2 == 0 && c==0 || str.length()%2 !=0 && c ==1) {
            return true;
        }
        return false;
    }
}
