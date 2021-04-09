package mediium;

import java.util.*;

public class KClosestPoints {
	public int[][] kClosest(int[][] points, int K) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<points.length;i++) {
            int d= getDistance(points[i][0],points[i][1]);
            map.put(i,d);
        }
        
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
            
        });
        
        int[][] closest = new int[points.length][2];
        int i = 0;
        for(Map.Entry<Integer, Integer> e:list) {
            if(i == K) {
                break;
            }
            int p = e.getKey();
            closest[i][0] = points[p][0];
            closest[i++][1] = points[p][1];
        }
        
        return closest;
    }
    
    private int getDistance(int x, int y) {
        return (x*x)+(y*y);
    }

}
