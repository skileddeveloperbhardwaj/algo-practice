package company.adobe;

public class TwoSpecialCharacters {
    public static void main(String[] args) {
        System.out.print(new TwoSpecialCharacters().isOneBitCharacter(new int[]{0, 0}));
    }
    public boolean isOneBitCharacter(int[] bits) {
        for(int i=0;i<bits.length;) {
            if(bits[i] == 0) {
                if( i==bits.length-1) return true;
                else i++;
            } else {
                i+=2;
            }
        }
        return false;
    }
}
