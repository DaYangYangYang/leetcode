package Arithmetic.BiTree;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;

public class Invert_Binary_Tree {
    public static void main(String[] args) {

    }


    public static Tree_Node invertTree(Tree_Node root) {
        if (root == null)
            return null;
        Tree_Node left = root.left;
        Tree_Node right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
