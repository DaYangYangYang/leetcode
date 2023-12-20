package Arithmetic.BiTree;

import javax.swing.tree.TreeNode;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Binary_Tree_Level_Order_Traversal_Two {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrderBottom(Tree_Node root) {
        Queue<Tree_Node> que = new LinkedBlockingDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        que.add(root);
        while (!que.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int len = que.size();
            for (int i = 0; i < len; i++) {
                Tree_Node remove = que.remove();
                if (remove.left != null)
                    que.add(remove.left);
                if (remove.right != null)
                    que.add(remove.right);
                list.add(remove.val);
            }
            result.add(list);
        }

        Collections.reverse(result);
        return result;
    }
}
