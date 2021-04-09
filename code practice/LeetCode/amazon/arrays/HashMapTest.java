package amazon.arrays;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("h","hello");
        map.put("h","hell");

        System.out.print(map.get("h"));
    }
}
