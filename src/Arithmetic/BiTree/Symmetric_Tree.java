package Arithmetic.BiTree;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.IntFunction;

public class Symmetric_Tree {
    public static void main(String[] args) {
        Tree_Node root = Create_Tree.create_Node();
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(Tree_Node root) {
        if (root == null)
            return false;
        if (isEqual(root.left, root.right))
            return true;
        return false;
    }

    public static boolean isEqual(Tree_Node left, Tree_Node right){
        if (left == null && right == null)
            return true;
        if ((left != null && right == null) || (left == null && right != null))
            return false;
        if (left.val != right.val)
            return false;
        if (isEqual(left.left, right.right) && isEqual(left.right, right.left))
            return true;
        return false;
    }
}
