package Arithmetic.BiTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Find_Largest_Value_in_Each_Tree_Row {
    public static void main(String[] args) {
        Tree_Node root = Create_Tree.create_Node();
        System.out.println(largestValues(root));
    }

    public static List<Integer> largestValues(Tree_Node root) {
        Queue<Tree_Node> que = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        que.add(root);
        while (!que.isEmpty()){
            int len = que.size();
            int max = que.peek().val;
            while (len > 0){
                Tree_Node tmp = que.remove();
                int cur = tmp.val;
                if (tmp.left != null)
                    que.add(tmp.left);
                if (tmp.right != null)
                    que.add(tmp.right);
                max = max > cur ? max : cur;
                len--;
            }
            list.add(max);
        }
        return list;
    }
}
