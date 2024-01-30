package Arithmetic.BiTree;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.BiConsumer;

public class Maximum_Binary_Tree {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        Tree_Node root = constructMaximumBinaryTree(nums);
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);

    }

    public static Tree_Node constructMaximumBinaryTree(int[] nums) {
        TreeMap<Integer, Integer> tm = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            tm.put(nums[i], i);
        }
        return construct(0, nums.length - 1, tm);
    }

    public static Tree_Node construct(int pre, int post, TreeMap<Integer, Integer> tm) {
        if (pre > post)
            return null;
        Set<Map.Entry<Integer, Integer>> entries = tm.entrySet();
        int rootVal = 0;
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            index = entry.getValue();
            if (index >= pre && index <= post){
                rootVal = entry.getKey();
                break;
            }
        }
        Tree_Node root = new Tree_Node(rootVal);
        root.left = construct(pre, index - 1, tm);
        root.right = construct(index + 1, post, tm);
        return root;
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
