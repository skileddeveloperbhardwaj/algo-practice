package tree.medium;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MergeBinaryTrees {
    //    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        int h1 = computeHeight(root1);
//        int h2 = computeHeight(root2);
//
//        if (h1 >= h2) {
//            merge(root1, root2);
//            return root1;
//        } else {
//            merge(root2, root1);
//            return root2;
//        }
//    }
//
//    private int computeHeight(TreeNode node) {
//        if(node == null) return 0;
//        if(node.left == null && node.right == null) return 1;
//        return Math.max(computeHeight(node.left), computeHeight(node.right))+1;
//    }
//
//    private void merge(TreeNode root1, TreeNode root2) {
//        Queue<TreeNode> q1 = new LinkedList();
//        Queue<TreeNode> q2 = new LinkedList();
//        q1.add(root1);
//        q2.add(root2);
//
//        while(!q1.isEmpty() && !q2.isEmpty()) {
//            TreeNode n1 = q1.remove();
//            TreeNode n2 = q2.remove();
//            if(n1 == null && n2 == null) continue;
//            if(n1 != null && n2 != null) {
//                n1.val = n1.val+n2.val;
//                q1.add(n1.left);
//                q1.add(n1.right);
//                q2.add(n2.left);
//                q2.add(n2.right);
//            }
//            if(n1 == null) {
//                n1 = new TreeNode(n2.val);
//            }
//        }
//    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root2.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
