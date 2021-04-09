package tree.easy;

import tree.TreeNode;

public class DiameterOfTree {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return ans;
    }

    private int diameter(TreeNode node) {
        if(node == null) return 0;
        int left = diameter(node.left);
        int right = diameter(node.right);
        ans = Math.max(left+right, ans);
        return Math.max(left, right)+1;
    }
}
