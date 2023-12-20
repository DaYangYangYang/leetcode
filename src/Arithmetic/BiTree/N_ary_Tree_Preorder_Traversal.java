package Arithmetic.BiTree;


import java.util.ArrayList;
import java.util.List;

public class N_ary_Tree_Preorder_Traversal {
    public static void main(String[] args) {

    }

    public static List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        pre(root, list);
        return list;
    }

    public static void pre(Node root, List<Integer> list){
        if (root == null)
            return;
        List<Node> children = root.children;
        list.add(root.val);
        for (Node child : children) {
            pre(child, list);
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
