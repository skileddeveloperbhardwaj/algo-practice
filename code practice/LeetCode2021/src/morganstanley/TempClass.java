package morganstanley;

import java.util.HashSet;
import java.util.Set;

public class TempClass {
    public static boolean isDiffPairExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++) {
            set.add(arr[i]);
        }

        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr.length;j++) {
                if(set.contains(arr[i]-arr[j])) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isDiffPairExist(new int[]{2,5,8,7,6}));
        System.out.println(isDiffPairExist(new int[]{9,10,11}));
        System.out.println(isDiffPairExist(new int[]{9,9,9,0}));
    }
}
