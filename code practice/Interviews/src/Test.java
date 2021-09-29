public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        change(arr);
        System.out.println(arr[0]);
    }

    private static void change(int[] arr) {
        arr[0] = 4;
    }
}
