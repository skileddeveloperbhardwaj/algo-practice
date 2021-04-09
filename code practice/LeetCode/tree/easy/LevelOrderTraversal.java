package tree.easy;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> list = new ArrayList<>();
//        TreeNode node = root;
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<Integer> l =new ArrayList<>();
//        l.add(node.val);
//        list.add(l);
//        queue.add(node);
//        while(node == null || !queue.isEmpty()) {
//            List<Integer> children = new ArrayList<>();
//            node = queue.remove();
//            children.add(node.left.val);
//            queue.add(node.left);
//            children.add(node.right.val);
//            queue.add(node.right);
//            list.add(children);
//        }
//        return list;
//    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            levels.add(new ArrayList<>());
             for(int i=0;i<levelSize;i++) {
                 TreeNode node = queue.remove();
                 levels.get(level).add(node.val);
                 if(node.left != null) queue.add(node.left);
                 if(node.right != null) queue.add(node.right);
             }
             level++;
        }

        return levels;
    }
}
