package tree.easy;

import tree.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isSubtreeHelper(s, t);
    }

    private boolean isSubtreeHelper(TreeNode s, TreeNode t) {
        if(s == null) return true;
        if(t==null) return false;
        return areIdentical(s, t) || isSubtreeHelper(s.left, t)
                || isSubtreeHelper(s.right, t);
    }

    private boolean areIdentical(TreeNode s, TreeNode t) {
        if(s ==null && t==null) return true;
        if(s==null || t==null) return false;
        return ((s.val == t.val) && areIdentical(s.left, t.left)
                && areIdentical(s.right, t.right));
    }
}

