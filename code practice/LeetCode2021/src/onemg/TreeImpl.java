package onemg;

import java.util.LinkedList;
import java.util.Queue;

public class TreeImpl {
    TreeNode root;

    public void insert(int val) {
        if(root == null) {
            root = new TreeNode(val);
            return;
        }

        TreeNode temp = root;
        TreeNode prev = null;
        while(temp != null) {
            prev = temp;
            if(val > temp.val) {
                temp= temp.right;
            } else {
                temp = temp.left;
            }
        }
        if(prev.val < val) {
            prev.right = new TreeNode(val);
        } else {
            prev.left = new TreeNode(val);
        }
    }

    public void search(int key) {
        Queue<Integer> q = new LinkedList<>();
        TreeNode node = root;
        q.add(node.val);
        while(node != null && key !=node.val ) {
            if(node.val > key) {
                node = node.left;
            } else {
                node = node.right;
            }
            q.add(node.val);
        }
       if(node == null) {
           System.out.println("Node not found!!");
           return;
       }
       for(int i:q) {
           System.out.print(i+"-->");
       }
    }

    public void inorder(TreeNode node) {
        if(node == null) return;
        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
    }

    public static void main(String[] args) {
        TreeImpl t = new TreeImpl();
        t.insert(7);
        t.insert(4);
        t.insert(5);
        t.insert(3);
        t.insert(10);
        t.insert(8);
        t.insert(9);
//        t.inorder(t.root);
//        t.search(9);
        t.search(3);

    }
}
