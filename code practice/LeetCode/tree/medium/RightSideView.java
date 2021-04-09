package tree.medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        TreeNode temp = null;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0;i<size;i++) {
                temp = queue.remove();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }
}
