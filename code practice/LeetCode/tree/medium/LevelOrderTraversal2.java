package tree.medium;

import tree.TreeNode;

import java.util.*;

/**
 * Bottom to Top Level order traversal
 */
public class LevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<List<Integer>> st = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        st.push(list);

        while(!q.isEmpty()) {
            ArrayList<Integer> l = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode node = q.remove();
                if(node.left != null) {
                    q.add(node.left);
                    l.add(node.left.val);
                }
                if(node.right != null) {
                    q.add(node.right);
                    l.add(node.right.val);
                }
            }
            st.push(l);
        }

        while(!st.isEmpty()) {
            result.add(st.pop());
        }
        return result;
    }
}
