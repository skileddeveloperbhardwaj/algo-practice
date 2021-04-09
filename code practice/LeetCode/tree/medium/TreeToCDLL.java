package tree.medium;

import tree.TreeNode;

public class TreeToCDLL {
    TreeNode first = null;
    TreeNode last = null;

    public TreeNode treeToDoublyList(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode node) {
        if(node != null) {
            helper(node.left);
            if(last == null) {
                first = node;
            } else {
                last.right = node;
                node.left = last;
            }
            last = node;
            helper(node.right);
        }
    }
}
