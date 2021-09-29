package hackerrank.array;

import java.util.*;

public class RansomNotes {
    public static void main(String[] args) {
    }

    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> magMap = new HashMap<String, Integer>();
        for (int i = 0; i < magazine.size(); i++) {
            if (magMap.getOrDefault(magazine.get(i), 0) == 0) {
                magMap.put(magazine.get(i), 1);
            } else {
                magMap.put(magazine.get(i), magMap.getOrDefault(magazine.get(i), 0) + 1);
            }
        }

        for (String str : note) {
            if (magMap.getOrDefault(str, 0) == 0) {
                System.out.println("No");
                return;
            } else {
                magMap.put(str, magMap.getOrDefault(str, 0) - 1);
            }
        }
        System.out.println("Yes");
    }
}
