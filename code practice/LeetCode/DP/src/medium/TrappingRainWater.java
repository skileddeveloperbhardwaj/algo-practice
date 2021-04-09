package medium;

public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.print(new TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int[] maxHeightFromLeft = new int[height.length];
        int[] maxHeightFromRight = new int[height.length];
        int count = 0;
        maxHeightFromLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxHeightFromLeft[i] = (height[i - 1] > maxHeightFromLeft[i - 1]) ? height[i - 1] : maxHeightFromLeft[i - 1];
        }
        maxHeightFromRight[height.length - 1] = height[height.length - 1];

        for (int i = height.length - 2; i >= 0; i--) {
            maxHeightFromRight[i] = (height[i + 1] > maxHeightFromRight[i + 1]) ? height[i + 1] : maxHeightFromRight[i + 1];
        }

        for (int i = 0; i < height.length; i++) {
            int diff = Math.min(maxHeightFromLeft[i], maxHeightFromRight[i]) - height[i];
            if(diff<=0) diff = 0;
            count += diff;
        }

        return count;
    }
}
