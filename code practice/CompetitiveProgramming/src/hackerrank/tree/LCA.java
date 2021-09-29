package hackerrank.tree;

public class LCA {
    private static Node ans;

    public static Node lca(Node node, int v1, int v2) {
        // Write your code here.
        recurseTree(node, v1, v2);
        return ans;
    }

    private static boolean recurseTree(Node node, int p, int q) {
        if(node == null) return false;
        int left = recurseTree(node.left, p, q)?1:0;
        int right = recurseTree(node.right, p, q)?1:0;

        int mid = ((node.data == p) ||(node.data == q))?1:0;

        if(mid+left+right == 2) {
            ans = node;
        }
        return (mid+left+right)>0;
    }
}