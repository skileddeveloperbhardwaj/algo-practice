package hard;

public class TrappingRainWater {
	public static void main(String[] args) {
		TrappingRainWater tr = new TrappingRainWater();
		int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(tr.trap(height));
	}

    public int trap(int[] height) {
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        int leftPtr = 0, rightPtr = height.length-1;
        
        while(leftPtr < rightPtr) {
        	if(height[leftPtr] < height[rightPtr]) {
        		if(height[leftPtr] > leftMax) {
        			leftMax = height[leftPtr];
        		} else {
        			ans += leftMax - height[leftPtr];
        		}
        		leftPtr++;
        	} else {
        		if(height[rightPtr] > rightMax) {
        			rightMax = height[rightPtr];
        		} else {
        			ans += rightMax - height[rightPtr];
        		}
        		rightPtr--;
        	}
        }
        
        return ans;
    }
}
