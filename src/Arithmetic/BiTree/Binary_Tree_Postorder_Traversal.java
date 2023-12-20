package Arithmetic.BiTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Postorder_Traversal {
    public static void main(String[] args) {

    }

    public static List<Integer> postorderTraversal(Tree_Node root) {
        List<Integer> list = new ArrayList<>();
        postorderT(root, list);
        return list;
    }

    public static void postorderT(Tree_Node root, List<Integer> list){
        if (root == null)
            return;
        postorderT(root.left, list);
        postorderT(root.right, list);
        list.add(root.val);
    }

    public static List<Integer> postorderTraversal2(Tree_Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Tree_Node> stack = new Stack<>();
        Tree_Node node = null;
        while (root != null || !stack.isEmpty()){
            if (root == null){
                root = stack.peek();
                if (root.right != null && root.right != node){
                    root = root.right;
                }else{
                    list.add(root.val);
                    node = root;
                    root = null;
                    stack.pop();
                }
            }else{
                stack.push(root);
                root = root.left;
            }
        }

        return list;
    }
}
