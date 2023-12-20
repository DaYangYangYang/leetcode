package Arithmetic.BiTree;

public class Tree_Node {
    int val;
    Tree_Node left;
    Tree_Node right;

    public Tree_Node(){
    }

    public Tree_Node(int val){
        this.val = val;
    }

    public Tree_Node(int val, Tree_Node left, Tree_Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
