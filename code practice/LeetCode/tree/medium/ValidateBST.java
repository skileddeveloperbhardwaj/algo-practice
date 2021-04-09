package tree.medium;

import tree.TreeNode;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
         return validateBST(root, null, null);
    }

    private boolean validateBST(TreeNode node, Integer low, Integer high) {
        if(node == null) return true;

        if((low != null && node.val <low) && (
        high != null && node.val >high)) {
            return false;
        }

        return validateBST(node.left, low, node.val) &&
                validateBST(node.right, node.val, high);
    }
}
