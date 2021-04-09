package array_strings;

public class IsUnique {
    public boolean isUnique(String str) {
        int[] count = new int[26];
        boolean isUnique;
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
            if (count[str.charAt(i) - 'a'] > 1) {
                return false;
            }
        }

        return true;
    }

    //using boolean array
    public boolean isUnique2(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            if (charSet[str.charAt(i)]) {
                return false;
            }
            charSet[str.charAt(i)] = true;
        }
        return true;
    }

    public boolean isUniqueBitwise(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if((checker & (1<<index)) > 0) {
                return false;
            }
            checker |= (1<<index);
        }
        return true;
    }

    public static void main(String[] args) {
//        boolean b = new IsUnique().isUnique("helo");
//        boolean b = new IsUnique().isUnique2("helol");
        boolean b = new IsUnique().isUniqueBitwise("helo");
        System.out.println(b);
    }
}
