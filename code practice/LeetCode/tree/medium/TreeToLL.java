package tree.medium;

import tree.TreeNode;

public class TreeToLL {
    TreeNode first, last;

    public void flatten(TreeNode root) {
        flatterHelper(root);
    }

    private TreeNode flatterHelper(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;
        TreeNode leftTail = flatterHelper(node.left);
        TreeNode rightTail = flatterHelper(node.right);
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        return rightTail == null ? leftTail : rightTail;
    }
}
