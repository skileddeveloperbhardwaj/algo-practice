package mock.adobe;

public class FlowerBed {

    public static void main(String[] args) {
        System.out.print(new FlowerBed().canPlaceFlowers(new int[]{0}, 1));
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length ==1 & flowerbed[0] == 0 && n==1 ) return true;
        for (int i = 0; i < flowerbed.length && n>0; i++) {
            if (flowerbed[i] != 1) {
                if (i == 0 && isValid(i + 1, flowerbed)) {
                    flowerbed[0] = 1;
                    n--;
                } else if (isValid(i - 1, flowerbed) && isValid(i + 1, flowerbed)) {
                    flowerbed[i] = 1;
                    n--;
                } else if(i==flowerbed.length-1) {
                    if(isValid(i-1, flowerbed)) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }
        }

        if(n>0) return false;
        return true;
    }

    private boolean isValid(int i, int[] flowerbed) {
        if (i >= 0 && i < flowerbed.length && flowerbed[i] == 0) return true;
        return false;
    }
}
