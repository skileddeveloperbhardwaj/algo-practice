package tree;

import java.util.Stack;

public class IterativeInorder {
	TreeNode root;

	public void inorder() {
	    Stack<TreeNode>	inStack = new Stack<TreeNode>();
        TreeNode current = root;
        
        while(current != null || !inStack.isEmpty()) {
        	if(current != null) {
        		inStack.add(current);
        		current = current.left;
        	} else {
        		TreeNode node = inStack.pop();
        		System.out.print(node.data+" ");
        		current = node.right;
        	}
        }
	}
	
	public static void main(String[] args) {
		IterativeInorder tree = new IterativeInorder(); 
        tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(3); 
        tree.root.left.left = new TreeNode(4); 
        tree.root.left.right = new TreeNode(5); 
        tree.inorder(); 
	}
	
}
