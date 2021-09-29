package hackerrank.tree;

public class HeightOfTree {
    public static int height(Node root) {
        // Write your code here.
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return (left>right?left:right)+1;
    }
}
