package misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<Node> getLevelOrderTraversal(Node root, int gen) {
        List<Node> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Node node = q.poll();
                for(int j=0;j<node.childNodes.size();j++) {
                        q.offer(node.childNodes.get(j));
                        if(level == gen) {
                            result.add(node.childNodes.get(j));
                            break;
                        }
                    }
                }
            level++;
            }
        return result;
    }
}

class Node {
    int val;
    List<Node> childNodes;

    public void Node(int val) {
        this.val = val;
        childNodes = new ArrayList<>();
    }
}
