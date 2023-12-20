package Arithmetic.BiTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

public class Binary_Tree_Preorder_Traversal {
    public static void main(String[] args) {
        Tree_Node head = Create_Tree.create_Node();
        List<Integer> list = preorderTraversal2(head);
        list.stream().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    //递归
    public static List<Integer> preorderTraversal(Tree_Node root){
        List<Integer> list = new ArrayList<>();
        PreTraversal(root, list);
        return list;
    }

    public static void PreTraversal(Tree_Node root, List<Integer> list){
        if (root == null)
            return;
        list.add(root.val);
        PreTraversal(root.left, list);
        PreTraversal(root.right, list);
    }

    //非递归
    public static List<Integer> preorderTraversal2(Tree_Node root){
        Stack<Tree_Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }else {
            return new ArrayList<Integer>();
        }

        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }

        return list;
    }
}
