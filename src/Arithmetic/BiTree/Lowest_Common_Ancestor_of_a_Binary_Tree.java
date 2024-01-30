package Arithmetic.BiTree;

import javax.swing.tree.TreeNode;
import java.util.Stack;

public class Lowest_Common_Ancestor_of_a_Binary_Tree {
    public static void main(String[] args) {
        Tree_Node root = Create_Tree.create_Node();
        System.out.println(lowestCommonAncestor(root, 5, 1) == null ? null : lowestCommonAncestor(root, 5, 1).val);
    }

    public static Tree_Node lowestCommonAncestor(Tree_Node root, int p, int q) {
        Stack<Tree_Node> ps = new Stack<>();
        Stack<Tree_Node> qs = new Stack<>();
        Stack<Tree_Node> stack = new Stack<>();
        Tree_Node cur = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                Tree_Node peek = stack.peek();
                if (peek.right == null || peek.right == cur) {
                    if (peek.val == p)
                        ps = copy(stack);
                    else if (peek.val == q)
                        qs = copy(stack);
                    cur = peek;
                    root = null;
                    stack.pop();
                }
                else root = peek.right;
            }
        }
        if (ps.size() < qs.size()) {
            Stack<Tree_Node> tmp = copy(qs);
            qs = copy(ps);
            ps = copy(tmp);
        }
        Tree_Node[] pnum = new Tree_Node[ps.size()];
        for (int i = pnum.length - 1; i >= 0; i--) {
            pnum[i] = ps.pop();
        }
        Tree_Node[] qnum = new Tree_Node[qs.size()];
        for (int i = qnum.length - 1; i >= 0; i--) {
            qnum[i] = qs.pop();
        }
        for (int i = pnum.length - 1; i >= 0; i--) {
            for (int j = qnum.length - 1; j >= 0; j--) {
                if (pnum[i] == qnum[j])
                    return pnum[i];
            }
        }
        return null;
    }

    public static Stack<Tree_Node> copy(Stack<Tree_Node> stack) {
        Stack<Tree_Node> tmp1 = new Stack<>();
        Stack<Tree_Node> tmp2 = new Stack<>();
        while (!stack.isEmpty()){
            Tree_Node pop = stack.pop();
            tmp1.push(pop);
            tmp2.push(pop);
        }
        Stack<Tree_Node> copy = new Stack<>();
        while (!tmp1.isEmpty()) {
            copy.push(tmp1.pop());
        }

        while (!tmp2.isEmpty()) {
            stack.push(tmp2.pop());
        }
        return copy;
    }
}
