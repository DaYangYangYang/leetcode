package Arithmetic.BiTree;

import javax.swing.tree.TreeNode;

public class Count_Complete_Tree_Nodes {
    public static void main(String[] args) {

    }

    public static int countNodes(Tree_Node root) {
        if (root == null)
            return 0;
        int h = 0;
        Tree_Node node = root.left;
        while (node != null){
            h++;
            node = node.left;
        }
        for (int number = (int) Math.pow(2, h); number <= Math.pow(2, h + 1) - 1; number++) {
            String s = tranToBinary(number);
            node = root;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '0')
                    node = node.left;
                else node = node.right;
            }
            if (node == null)
                return number - 1;
        }
        return (int) Math.pow(2, h + 1) - 1;
    }

    public static String tranToBinary(int count) {
        StringBuilder sb = new StringBuilder();
        while (count != 0) {
            sb.insert(0, count % 2);
            count /= 2;
        }
        return sb.toString();
    }
}
