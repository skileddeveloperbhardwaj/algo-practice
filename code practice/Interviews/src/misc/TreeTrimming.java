package misc;

import java.util.*;

public class TreeTrimming {
    public TreeNode getTrimmedTree(TreeNode root, int[] range) {

        TreeNode curr = root;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode node = q.poll();
                if(node.left != null) {
                    q.offer(node.left);
                    parentMap.put(node.left, node);
                }

                if(node.right != null) {
                    q.offer(node.right);
                    parentMap.put(node.right, node);
                }
                if(node.val < range[0]) {
                    deleteNode(root, node, parentMap, true);
                } else if(node.val > range[1]) {
                    deleteNode(root, node, parentMap, false);
                }
            }
        }
        return root;
    }

    private void deleteNode(TreeNode root, TreeNode node, Map<TreeNode, TreeNode> parentMap, boolean isLeft) {
        TreeNode parent = parentMap.get(node);
        if(isLeft) {
            if(parent == null) {
                root = root.right;
                return;
            }
            parent.left = node.right;
        } else {
            if(parent == null) {
                root = root.left;
                return;
            }
            parent.right = node.left;
        }
    }

    public List<Integer> getRemainingAsteroids(int[] arr) {
        Stack<Integer> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            if(arr[i] > 0 || st.isEmpty()) {
                st.push(arr[i]);
                continue;
            }
            int lastAsteroidSize = 0;
            while(!st.isEmpty() &&  st.peek() <= Math.abs(arr[i])) {
                lastAsteroidSize = st.pop();
            }
            if(lastAsteroidSize != Math.abs(arr[i])) {
                result.add(arr[i]);
            }
        }

        while(!st.isEmpty()) {
            result.add(st.pop());
        }

        return result;
    }
}

class TreeNode {
    TreeNode right;
    TreeNode left;
    int val;

    public TreeNode(int val) {
        this.val = val;
        right = left = null;
    }
}
