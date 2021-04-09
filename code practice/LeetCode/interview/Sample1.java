package interview;

public class Sample1 {

    public static void main(String[] args) {
        System.out.print(new Sample1().longestPalidromicSubString("goibiibii"));
    }

    public String longestPalidromicSubString(String s) {
        String rev = getReverse(s);
        String pal = "";
        int lenInc = -1;
        int lenExc = -1;
        for(int i=0;i<rev.length();i++) {
            //inclusive of last character
            int index = rev.indexOf(s.substring(i, s.length()));
            if(index != -1) {
                lenInc = Math.max(s.length() -i, lenInc);
            }

            int index2 = rev.indexOf(s.substring(i, s.length()-1));
            if(index2 != -1) {
                lenExc = Math.max(s.length()-1-i, lenExc);
            }

        }
        return "";
    }

    private String getReverse(String s) {
        String rev = new String();
        for(int i=s.length()-1;i>=0;i--) {
            rev +=s.charAt(i);
        }
        return rev;
    }
}
