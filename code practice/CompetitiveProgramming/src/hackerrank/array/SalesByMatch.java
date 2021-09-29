package hackerrank.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SalesByMatch {
    public static void main(String[] args) {
        List ar = new ArrayList();
        int[] arr = new int[]{1,2,1,2,1,3,2};
        for(int i:arr)
            ar.add(i);
        System.out.print(SalesByMatch.sockMerchant(7, ar));
    }
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        for(int i=0;i<ar.size();i++) {
            map.put(ar.get(i), map.getOrDefault(ar.get(i), 0)+1);
            set.add(ar.get(i));
        }

        for(Integer i:set) {
            pairs += map.get(i)/2;
        }

        return pairs;
    }
}
