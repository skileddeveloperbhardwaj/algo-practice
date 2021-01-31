package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels labels =  new PartitionLabels();
        List<Integer> list = labels.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(list);
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> lengthList = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i), i);
        }
        int j=-1, prev =0;
        for(int i=0;i<s.length();i++) {
            if(j<map.get(s.charAt(i))) {
                j = map.get(s.charAt(i));
            }
            if(i==j) {
                lengthList.add(j+1);
            }
        }

        for(int i=1;i<lengthList.size();i++) {
            prev = lengthList.get(i-1);
            lengthList.set(i, lengthList.get(i) - lengthList.get(i-1));
        }
        return lengthList;
    }
}
