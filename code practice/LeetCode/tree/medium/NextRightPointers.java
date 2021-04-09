package tree.medium;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class NextRightPointers {
    public TreeNode connect(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0;i<size-1;i++) {
                TreeNode node = queue.remove();
//                node.next = queue.peek();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            TreeNode node = queue.remove();
//            node.next = null;
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        return root;
    }
}
