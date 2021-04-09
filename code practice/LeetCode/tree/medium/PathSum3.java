package tree.medium;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {
    int count;
    int mSum;
    Map<Integer, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int sum) {
        mSum = sum;
         preorder(root, 0);
         return count;
    }

    private void preorder(TreeNode node, int currsum) {
        if(node == null) {
            return;
        }
        currsum+=node.val;
        if(currsum == mSum) count++;
        count += map.getOrDefault(currsum-mSum,0);
        map.put(currsum, map.getOrDefault(currsum,0));
        preorder(node.left, currsum);
        preorder(node.right, currsum);
        map.put(currsum, map.get(currsum)-1);
    }
}
