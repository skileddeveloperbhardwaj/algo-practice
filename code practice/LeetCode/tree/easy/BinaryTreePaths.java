package tree.easy;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, "");
        return result;
    }

    private void helper(TreeNode node, String s) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            s+=node.val;
            result.add(s);
            return;
        }
        s+=node.val +"->";
        helper(node.left, s);
        helper(node.right, s);
    }
}
