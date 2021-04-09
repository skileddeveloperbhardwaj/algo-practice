package tree.easy;

import tree.TreeNode;

public class SumRangeBST {
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return sum;
    }


    private void helper(TreeNode node, int low, int high) {
        if(node == null) return;

        if(low <=node.val && node.val<= high) {
            sum+=node.val;
        }

        helper(node.left, low, high);
        helper(node.right, low, high);
    }
}
