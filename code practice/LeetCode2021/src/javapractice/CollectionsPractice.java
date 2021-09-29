package javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsPractice {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(9);
        list.add(11);
        Collections.sort(list, (o1, o2) -> o2-o1);

        for(int i:list) {
            System.out.println(i);
        }
    }
}
