package tree.easy;

import tree.TreeNode;

public class PathSum {
    boolean hasPath = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        helper(root, targetSum);
        return hasPath;
    }

    private void helper(TreeNode node, int targetSum) {
        if(node == null) return;
        if(node.left == null && node.right == null && (targetSum - node.val)== 0) {
            hasPath = true;
            return;
        }
        helper(node.left, targetSum-node.val);
        helper(node.right, targetSum-node.val);
    }
}
