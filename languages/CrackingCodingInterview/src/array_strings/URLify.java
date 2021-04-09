package array_strings;

public class URLify {
    public static void main(String[] args) {
        new URLify().URLify("Mr John Smith      ", 13);

    }

    public void URLify(String str, int len) {
        int actualLength = str.length();
        char[] ch = str.toCharArray();
        char[] temp = new char[actualLength];
        int k = 0;

        for(int i=0;i<len;i++) {
            if(ch[i] == ' ') {
                temp[k] = '%';
                temp[k+1] = '2';
                temp[k+2] = '0';
                k+=3;
            } else {
                temp[k++] = ch[i];
            }
        }
        for(int i=0;i<actualLength;i++) {
            System.out.print(temp[i]);
        }
        System.out.println();
    }
}
