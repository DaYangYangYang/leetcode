package Arithmetic.BiTree;

import javax.swing.tree.TreeNode;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Average_of_Levels_in_Binary_Tree {
    public static void main(String[] args) {

    }

    public static List<Double> averageOfLevels(Tree_Node root) {
        List<Double> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<Tree_Node> que = new LinkedBlockingDeque<>();
        que.add(root);
        while (!que.isEmpty()){
            int len = que.size();
            BigDecimal avg = new BigDecimal(0);
            for (int i = 0; i < len; i++) {
                Tree_Node tmp = que.remove();
                if (tmp.left != null)
                    que.add(tmp.left);
                if (tmp.right != null)
                    que.add(tmp.right);
                avg.add(new BigDecimal(tmp.val));
            }
            avg.divide(BigDecimal.valueOf(len));
            list.add(avg.setScale(5).doubleValue());
        }
        return list;
    }
}
