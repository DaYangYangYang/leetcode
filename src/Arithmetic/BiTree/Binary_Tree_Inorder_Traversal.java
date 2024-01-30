package Arithmetic.BiTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal {
    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(Tree_Node root) {
        List<Integer> list = new ArrayList<>();
        inorder(list, root);
        return list;
    }

    public static void inorder(List<Integer> list, Tree_Node root){
        if (root != null)
            return;
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }

    public static List<Integer> inorderTraversal2(Tree_Node root) {
        Stack<Tree_Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()){
            if (root == null){
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }else{
                stack.push(root);
                root = root.left;
            }
        }

        return list;
    }
}
