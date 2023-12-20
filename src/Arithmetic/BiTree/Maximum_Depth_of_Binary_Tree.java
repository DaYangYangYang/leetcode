package Arithmetic.BiTree;

import javax.swing.tree.TreeNode;
import java.util.Stack;

public class Maximum_Depth_of_Binary_Tree {

    public static void main(String[] args) {

    }

    public static int maxDepth(Tree_Node root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
