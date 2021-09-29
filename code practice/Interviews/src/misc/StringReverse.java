package misc;

public class StringReverse {
    public static String reverseString(String str) {
        String specialStr  = "!@#$%^&*()_+=";
        int left = 0;
        int right = str.length()-1;
        char[] ch = str.toCharArray();
        while(left <right) {
            while(specialStr.indexOf(ch[left]) > 0) left++;
            while(specialStr.indexOf(ch[right]) > 0) right--;
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for(char c:ch) {
            sb.append(c);
        }
      return sb.toString();
    }

    public static int getSecondLargest(int[] arr) {
        int largest = arr[0];
        for(int i=0;i<arr.length;i++) {
            largest = Math.max(largest, arr[i]);
        }

        int secondLargest = arr[0];
        for(int i=1;i<arr.length;i++) {
            if(arr[i] < largest) {
                secondLargest = Math.max(arr[i], secondLargest);
            }
        }

        return secondLargest;
    }

    public static void main(String[] args) {
//        System.out.println(reverseString("ATY&OR@V"));
        System.out.println(getSecondLargest(new int[]{4,5,1,2,3,6}));
    }
}
