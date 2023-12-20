package Arithmetic.BiTree;

import javax.swing.tree.TreeNode;

public class Minimum_Depth_of_Binary_Tree {
    public static void main(String[] args) {

    }

    public static int minDepth(Tree_Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left == null)
            return minDepth(root.right) + 1;
        else if (root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
