package strings.easy;

public class CountABSubsequence {
    public static void main(String[] args) {
        System.out.print(new CountABSubsequence().countOccurrences("aacbd", 1));
    }
    public int countOccurrences(String str, int k) {
        int countOfA = 0;
        int count = 0;
        String s = "";
        for(int i=0;i<k;i++) {
            s+=str;
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') {
                countOfA++;
            } else if(s.charAt(i) == 'b') {
                count+=countOfA;
            }
        }
        return count;
    }
}
