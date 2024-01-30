package Arithmetic.BiTree;

import javax.swing.tree.TreeNode;

public class Merge_Two_Binary_Trees {
    public static void main(String[] args) {
        Tree_Node root1 = Create_Tree.create_Node();
        Tree_Node root2 = Create_Tree.create_Node();
        Tree_Node root = mergeTrees(root1, root2);
        System.out.println(root);
    }

    public static Tree_Node mergeTrees(Tree_Node root1, Tree_Node root2) {
        if (root1 == null && root2 == null)
            return null;
        Tree_Node node = null;
        if (root1 == null) {
            node = new Tree_Node(root2.val);
            node.left = mergeTrees(null, root2.left);
            node.right = mergeTrees(null, root2.right);
        }else if (root2 == null) {
            node = new Tree_Node(root1.val);
            node.left = mergeTrees(root1.left, null);
            node.right = mergeTrees(root1.right, null);
        }else {
            node = new Tree_Node(root1.val + root2.val);
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
        }
        return node;
    }
}
