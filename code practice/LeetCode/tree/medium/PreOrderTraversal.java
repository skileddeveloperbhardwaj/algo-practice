package tree.medium;

import tree.TreeNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
   /* public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node =  stack.pop();
            output.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return output;
    }*/

    //Morris traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        TreeNode node = root;
        TreeNode predecessor = null;
        while (node != null) {
            if (node.left == null) {
                //for linked nodes
                output.add(node.val);
                node = node.right;
            } else {
                predecessor = node.left;

                while (predecessor.right != null && predecessor.right != node) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = node;
                    output.add(node.val);
                    node = node.left;
                }
                //to remove morris node links
                if (predecessor.right == node) {
                    predecessor.right = null;
                    node = node.right;
                }
            }
        }
        return output;
    }
}
