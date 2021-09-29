package company.adobe;

import java.util.HashMap;
import java.util.HashSet;

public class Delicioiusness {
    public static void main(String[] args) {
        System.out.print(new Delicioiusness().countPairs(new int[]{1,3,5,7,9}));
    }

    public int countPairs1(int[] deliciousness) {
           int count = 0;
           for(int i=0;i<deliciousness.length;i++) {
               for(int j=i+1;j<deliciousness.length;j++) {
                   int sum = deliciousness[i]+deliciousness[j];
                   if(Math.log(sum)/Math.log(2)%2 == 0 || Math.log(sum)/Math.log(2)%2 == 1) {
                       count++;
                   }
               }
           }
        return count %(1000000007);
    }

    public int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        map.put(deliciousness[0],1);
        for(int i=1;i<deliciousness.length;i++) {
            int p=1;
            for(int j=0;j<=21;j++) {
                if(map.containsKey(p-deliciousness[i])) {
                    cnt += map.get(p-deliciousness[i]);
                    cnt%=1000000007;
                }
                p<<=1;
            }
            map.put(deliciousness[i],1+map.getOrDefault(deliciousness[i],0));
        }
        return cnt;
    }
}
