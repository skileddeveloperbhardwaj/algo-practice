import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ComplementPairs {
    private static List getPairs(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        List<Pair> pairs = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            if(set.contains(n-arr[i])) {
                pairs.add(new Pair(arr[i], n-arr[i]));
                set.remove(n-arr[i]);
            } else {
                set.add(arr[i]);
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        List<Pair> list = getPairs(new int[]{3,4,5,5,7,5,5,9}, 10);
        for(Pair p:list) {
            System.out.println(p.i+"  "+p.j);
        }
    }

}

class Pair {
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j =j;
    }
}
