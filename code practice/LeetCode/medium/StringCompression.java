package medium;

public class StringCompression {
    public static void main(String[] args) {
        int len = new StringCompression().compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'});
        System.out.print(len);
    }

    public int compress(char[] chars) {
        if(chars.length ==0 || chars.length ==1) {
            return chars.length;
        }
        char firstChar = chars[0];
        int j = 0;
        int c = 0, len = 0;

        for(int i=0;i<chars.length;i++) {
            if(firstChar == chars[i]) {
                c++;
            } else {
                if(c>1) {
                    chars[j++] = firstChar;
                    len++;
                    for(char ch:(""+c).toCharArray()) {
                        chars[j++] = ch;
                        len++;
                    }
                } else {
                    chars[j++] = firstChar;
                    len++;
                }
                firstChar = chars[i];
                c=1;
            }
        }
        if(c>1) {
            len++;
            chars[j++] = firstChar;
            for(char ch:(""+c).toCharArray()) {
                chars[j++] = ch;
                len++;
            }
        } else {
            chars[j++] = firstChar;
            len++;
        }
        return len;
    }
}
