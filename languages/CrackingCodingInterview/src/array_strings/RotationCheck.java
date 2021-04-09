package array_strings;

public class RotationCheck {
    private boolean isRotation(String src, String target) {
        String s = src + src;
        return isSubstr(s, target);
    }

    private boolean isSubstr(String s, String target) {
        int t = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == target.charAt(t)) {
                t++;
            } else {
                t = 0;
            }

            if (t == target.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.print(new RotationCheck().isRotation("waterbottle", "terbottlewa"));
    }
}
