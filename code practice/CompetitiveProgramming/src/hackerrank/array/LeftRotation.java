package hackerrank.array;

import java.util.ArrayList;
import java.util.List;

public class LeftRotation {
    public static void main(String[] args) {
        List l = new ArrayList();
        int[] arr= new int[]{1, 2, 3, 4, 5};
        for(int i:arr) {
            l.add(i);
        }
        List<Integer> list = LeftRotation.rotLeft(l, 4);
        for(Integer i:list) {
            System.out.println(i);
        }
    }
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            int index = i-d;
            if(index < 0) {
                index = a.size()+index;
            }
            arr[index] = a.get(i);
        }
        for(int i:arr) {
            list.add(i);
        }
        return list;
    }
}
