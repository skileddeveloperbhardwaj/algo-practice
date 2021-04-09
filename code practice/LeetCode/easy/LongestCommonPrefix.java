package easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String prefix = new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flowing","flying"});
        System.out.print(prefix);
    }

    /* public String longestCommonPrefix(String[] strs) {
        int[] len = new int[strs.length];

        for(int i=0;i<strs.length;i++) {
            len[i] = strs[i].length();
        }

        int min = len[0];
        for(int i=1;i<len.length;i++) {
            if(min >len[i]) {
                min = len[i];
            }
        }

        String prefix ="";
        for(int i=0;i<min;i++) {
            String ref = strs[0].substring(i,i+1);
            for(int j=1;j<strs.length;j++) {
                if(!ref.equals(strs[j].substring(i,i+1))) {
                    return prefix;
                }
            }
            prefix +=ref;
        }
        return prefix;
    }*/
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
