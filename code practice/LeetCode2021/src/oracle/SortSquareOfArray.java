package oracle;

import java.util.concurrent.ConcurrentHashMap;

public class SortSquareOfArray {
    public static int[] getSortedSquare(int[] arr) {
        int right = -1;
        int left = -1;
        for(int i=0;i<arr.length;i++) {
            //-4,-3,-1,1,2,3
            if(arr[i]>0) {
                right = i+1;
                left = i;
                break;
            }
        }

        if(right == -1) right = 0;
        int[] res = new int[arr.length];
        int k = 0;
        while(right < arr.length && left >=0) {
           if(arr[right] > -1*arr[left]) {
               res[k++] = arr[left]*arr[left];
               left--;
           } else {
               res[k++] = arr[right]*arr[right];
               right++;
           }
        }

        while(right < arr.length) {
            res[k++] = arr[right]*arr[right];
            right++;
        }

        while(left >=0) {
            res[k++] = arr[left]*arr[left];
            left--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = getSortedSquare(new int[]{-4,-3,-1,1,2,3});
        for(int i:arr){
            System.out.print(i+", ");
        }
    }
}
