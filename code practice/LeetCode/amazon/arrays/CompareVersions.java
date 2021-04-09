package amazon.arrays;

public class CompareVersions {
    public static void main(String[] args) {
        String version1 = "10.6.5";
        String version2 = "10.6";
        int equal = new CompareVersions().compareVersion(version1, version2);
        System.out.print(equal);
    }

    public int compareVersion(String version1, String version2) {
        String[] first = version1.split("\\.");
        String[] second = version2.split("\\.");

        int len = first.length < second.length ? first.length : second.length;

        for (int i = 0; i < len; i++) {
            if (Integer.parseInt(first[i]) < Integer.parseInt(second[i])) {
                return -1;
            } else if (Integer.parseInt(first[i]) > Integer.parseInt(second[i])) {
                return 1;
            }
        }

        if (first.length > second.length) {
            for (int i = second.length; i <second.length+(first.length - second.length); i++) {
                if (Integer.parseInt(first[i]) > 0) {
                    return 1;
                }
            }
        } else if (first.length < second.length) {
            for (int i = first.length; i < first.length+(second.length - first.length); i++) {
                if (Integer.parseInt(second[i]) > 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
