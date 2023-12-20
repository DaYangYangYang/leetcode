package Arithmetic.BiTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Binary_Tree_Level_Order_Traversal {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(Tree_Node root) {
        Queue<Tree_Node> que = new LinkedBlockingDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        que.add(root);
        int i = 1;//当前层的数量
        int j = 0;//下一层的数量
        while (!que.isEmpty()){
            List<Integer> list = new ArrayList<>();
            while (i > 0){
                Tree_Node tmp = que.remove();
                list.add(tmp.val);
                i--;
                if (tmp.left != null) {
                    que.add(tmp.left);
                    j++;
                }
                if (tmp.right != null) {
                    que.add(tmp.right);
                    j++;
                }
            }
            i = j;
            j = 0;
            result.add(list);
        }
        return result;
    }
}
