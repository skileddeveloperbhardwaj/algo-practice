package oracle;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static char getFirstNonRepeatingCharacter(String s) {
        if(s.length() == 0) return '$';
        Map<Character, Integer> map = new HashMap<>();

        for(Character ch:s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(Character ch: s.toCharArray()) {
            if(map.get(ch) == 1) {
                return ch;
            }
        }
        //in case all characters are repeating
        return '$';
    }

    public static void main(String[] args) {
        System.out.println(getFirstNonRepeatingCharacter("GAURAV"));
        System.out.print(getFirstNonRepeatingCharacter("GGAAUURRAAVV"));
    }
}
