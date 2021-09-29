package hackerrank.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TopView {
    public static void topView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node temp = root.left;
        while(temp != null) {
            queue.add(temp);
            temp = temp.left;
        }

        temp = root.right;
        while (temp != null) {
            queue.add(temp);
            temp = temp.right;
        }

        for(Node node: queue) {
            System.out.print(node.data + " ");
        }
    }
}
