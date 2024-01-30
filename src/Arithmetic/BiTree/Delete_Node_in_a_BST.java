package Arithmetic.BiTree;

import javax.swing.tree.TreeNode;

public class Delete_Node_in_a_BST {
    public static void main(String[] args) {

    }

    public static Tree_Node deleteNode(Tree_Node root, int key) {
        if (root == null)
            return null;
        Tree_Node pa = new Tree_Node(0, root, null);
        Tree_Node p = pa;
        Tree_Node node = root;
        while (node != null && node.val != key) {
            if (node.val < key) {
                pa = node;
                node = node.right;
            } else if (node.val > key) {
                pa = node;
                node = node.left;
            }
        }
        if (node != null) {
            if (pa.left == node) {
                pa.left = node.right;
                while (pa.left != null) {
                    pa = pa.left;
                }
                pa.left = node.left;
            } else if (pa.right == node) {
                pa.right = node.right;
                if (pa.right != null) {
                    pa = pa.right;
                    while (pa.left != null)
                        pa = pa.left;
                    pa.left = node.left;
                }
                else pa.right = node.left;
            }
        }
        return p.left;
    }
}
