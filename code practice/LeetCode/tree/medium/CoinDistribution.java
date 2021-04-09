package tree.medium;

import tree.TreeNode;

public class CoinDistribution {
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode node) {
        if(node == null) return 0;
        int l = helper(node.left);
        int r = helper(node.right);
        ans += Math.abs(l)+Math.abs(r);
        return node.val + l + r -1;
    }
}
