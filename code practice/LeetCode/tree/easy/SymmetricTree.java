package tree.easy;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {
    String in = "";
    String re = "";

//    public boolean isSymmetric(TreeNode root) {
//        inorder(root);
//        reverseInorder(root);
//        return in.equals(re);
//    }

    private void inorder(TreeNode root) {
        if (root == null) {
            in += "n";
            return;
        }
        in += root.val;
        inorder(root.left);
        inorder(root.right);
    }

    private void reverseInorder(TreeNode root) {
        if (root == null) {
            re += "n";
            return;
        }
        re += root.val;
        reverseInorder(root.right);
        reverseInorder(root.left);
    }

    //Iterative approach
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> inorder = new LinkedList();
        Queue<TreeNode> reveseInorder = new LinkedList();
        inorder.add(root);
        reveseInorder.add(root);

        while (!inorder.isEmpty() && !reveseInorder.isEmpty()) {
            int size = inorder.size();
            int revSize = reveseInorder.size();
            if(size != revSize) return false;
            for(int i=0;i<size;i++) {
                TreeNode node = inorder.remove();
                TreeNode rev = reveseInorder.remove();
                if(node.val != rev.val) return false;
                if(node.left != null) inorder.add(node.left);
                if(node.right != null) inorder.add(node.right);

                if(node.right != null) reveseInorder.add(node.right);
                if(node.left != null) reveseInorder.add(node.left);
            }
        }

        return true;
    }
}
