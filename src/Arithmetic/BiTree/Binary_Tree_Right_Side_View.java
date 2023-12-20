package Arithmetic.BiTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Binary_Tree_Right_Side_View {
    public static void main(String[] args) {
        Tree_Node root = Create_Tree.create_Node();
        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(Tree_Node root) {
        List<Integer> list = new ArrayList<>();
        Queue<Tree_Node> que = new LinkedBlockingDeque<>();
        if (root == null)
            return list;

        que.add(root);
        while (!que.isEmpty()){
            int len = que.size();
            while (len > 0){
                Tree_Node tmp = que.remove();
                if (len == 1){
                    list.add(tmp.val);
                }
                if (tmp.left != null){
                    que.add(tmp.left);
                }
                if (tmp.right != null) {
                    que.add(tmp.right);
                }
                len--;
            }
        }
        return list;
    }
}
