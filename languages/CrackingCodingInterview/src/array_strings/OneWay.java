package array_strings;

public class OneWay {
    public static void main(String[] args) {
        boolean b = new OneWay().isOneWay("pale", "blea");
        System.out.print(b);
    }

    public boolean isOneWay(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return isRemoved(str1, str2);
        } else if (str1.length() < str2.length()) {
            return isRemoved(str2, str1);
        } else {
            return isReplace(str1, str2);
        }
    }

    private boolean isRemoved(String str1, String str2) {
        int diff = 0;
        for (int i = 0, j = 0; i < str1.length() && j < str2.length(); ) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                diff++;
            }
        }

        if (diff == 1) {
            return true;
        }
        return false;
    }

    private boolean isReplace(String str1, String str2) {
        int diff = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
            }
        }

        if (diff > 1) {
            return false;
        }
        return true;
    }
}
