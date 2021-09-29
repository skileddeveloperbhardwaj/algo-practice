package javapractice;

import java.util.*;

public class MapPractice {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Hello");
        list.add("World");

        Collections.sort(list, String::compareTo);

        Map<String, Integer> map = new HashMap<>();

            map.put("hello", map.getOrDefault("hello",0)+1);
        map.put("hello ", map.getOrDefault("hello ",0)+1);

        for(Map.Entry<String, Integer> entry:map.entrySet()) {
            System.out.println(entry.getKey()+"::"+entry.getValue());
        }
    }
}
