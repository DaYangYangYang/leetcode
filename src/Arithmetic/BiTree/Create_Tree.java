package Arithmetic.BiTree;

import java.util.Scanner;

public class Create_Tree {
    public static Tree_Node create_Node(){
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        if (val < -100)
            return null;
        Tree_Node node = new Tree_Node(val);
        node.left = create_Node();
        node.right = create_Node();
        return node;
    }
}
