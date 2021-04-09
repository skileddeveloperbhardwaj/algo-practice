package mock.amazon;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeToNumber {
    public static void main(String[] args) {
        long num = Long.parseLong("11111010100");
        System.out.print(num);
    }
    List<String> list = new ArrayList<>();

    public int sumRootToLeaf(TreeNode root) {
        if(root == null) return 0;
        generateBinary(root, "");
        return sumHelper(list);
    }

    private void generateBinary(TreeNode node, String num) {
        if(node == null) return;
        if (node !=null && node.left == null && node.right == null) {
            list.add(num+node.val);
            return;
        }

        num += node.val;
        generateBinary(node.left, num);
        generateBinary(node.right, num);
    }

    private int sumHelper(List<String> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += binaryToDecimal(list.get(i));
        }
        return sum;
    }

    private int binaryToDecimal(String str) {
        int len = str.length();
        int dec = 0;
        int j = 0;
        for (int i = len-1; i >=0; i++) {
            dec += Integer.parseInt(str.substring(i-1,i)) * Math.pow(2, j++);
        }
        return dec;
    }
}
