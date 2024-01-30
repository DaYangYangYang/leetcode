package Arithmetic.BiTree;


import javax.swing.tree.TreeNode;
import java.util.Stack;

public class Path_Sum {
    public static void main(String[] args) {

    }

    public static boolean hasPathSum(Tree_Node root, int targetSum) {
        if (root == null)
            return false;
        if (root.val == targetSum && root.left == null && root.right == null)
            return true;
        if (hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val))
            return true;
        return false;
    }
}
