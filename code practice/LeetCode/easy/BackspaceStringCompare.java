package easy;

/**
 *
 * @author Gaurav
 *
 *         Google: Easy
 *         "xywrrmp"
 * "xywrrmu#p"
 *
 * "a##c"
 * "#a#c"
 * "y#fo##f"
 * "y#f#o##f"
 *
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare("y#fo##f", "y#f#o##f"));

    }

    public boolean backspaceCompare(String S, String T) {
        StringBuilder s = new StringBuilder(S);
        StringBuilder t = new StringBuilder(T);


        String ss = buildString(s);
        String tt = buildString(t);

        return ss.equals(tt);

    }

    private String buildString(StringBuilder s) {
        // TODO Auto-generated method stub
        for(int i=0;i<s.length();) {
            if(i-1>=0 && s.charAt(i) =='#') {
                s.deleteCharAt(i);
                s.deleteCharAt(i-1);
                i=i-1;
            } else {
                i++;
            }
        }
        return s.toString().replace("#","");
    }

}

