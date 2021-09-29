package backtracking;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<>();
        backTrack(results, candidates, 0, target, comb);
        return results;
    }

    public static void backTrack(List<List<Integer>> results, int[] candidates, int start, int rem, LinkedList<Integer> comb) {
        if(rem == 0) {
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        if(rem < 0) return;

        for(int i=start;i<candidates.length;i++) {
            comb.add(candidates[i]);
            backTrack(results, candidates, i, rem-candidates[i], comb);
            comb.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> results = combinationSum(new int[]{3,4,5}, 8);
        for(List<Integer> list:results) {
            for(Integer i:list) {
                System.out.print(i+" ");
            }

            System.out.println();
        }
    }
}
