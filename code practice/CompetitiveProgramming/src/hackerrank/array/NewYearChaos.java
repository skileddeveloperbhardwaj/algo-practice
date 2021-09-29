package hackerrank.array;

import java.util.ArrayList;
import java.util.List;

public class NewYearChaos {
    public static void main(String[] args) {
        int[] arr=new int[]{1, 2, 5, 4, 3,6,7,8};
        List<Integer> list = new ArrayList<>();
        for (int i:arr) {
            list.add(i);
        }
        NewYearChaos.minimumBribes(list);
    }
    public static void minimumBribes(List<Integer> q) {
        int bribes =0;
        int[] arr = new int[q.size()];
        for(int i=0;i<q.size();i++) {
            arr[i] = q.get(i);
        }
         for(int i=0;i<q.size();i++) {
             if((arr[i] -(i+1)) >=3) {
                 System.out.println("Too Chaotic");
                 return;
             }
             int j=i+1;
             while(arr[i] != (i+1)) {
                 if(arr[i] >arr[j]) {
                     int temp = arr[i];
                     arr[i] = arr[j];
                     arr[j] = temp;
                     bribes++;
                 }
                 j++;
             }
         }
         System.out.println(bribes);
    }
}
