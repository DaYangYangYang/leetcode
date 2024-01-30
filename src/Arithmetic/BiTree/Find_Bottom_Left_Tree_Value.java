package Arithmetic.BiTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Find_Bottom_Left_Tree_Value {
    public static void main(String[] args) {

    }

    public static int findBottomLeftValue(Tree_Node root) {
        Queue<Tree_Node> que = new ArrayDeque<>();
        int left = root.val;
        que.add(root);
        while (!que.isEmpty()) {
            left = que.peek().val;
            int len = que.size();
            for (int i = 0; i < len; i++) {
                Tree_Node remove = que.remove();
                if (remove.left != null)
                    que.add(remove.left);
                if (remove.right != null)
                    que.add(remove.right);
            }
        }
        return left;
    }
}
