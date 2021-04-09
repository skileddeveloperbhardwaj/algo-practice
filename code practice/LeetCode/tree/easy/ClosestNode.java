package tree.easy;

import tree.TreeNode;

public class ClosestNode {
    double minDiff = Double.MAX_VALUE;
    int val;

    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return val;
    }

    private void helper(TreeNode node, double target) {
        if (node == null) return;
        if (minDiff > Math.abs(target - node.val)) {
            minDiff = Math.abs(target - node.val);
            val = node.val;
        }

        helper(node.left, target);
        helper(node.right, target);
    }
}
