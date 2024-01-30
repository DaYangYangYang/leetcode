package Arithmetic.BiTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Construct_Binary_Tree_from_Inorder_and_Postorder {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        Tree_Node root = buildTree(inorder, postorder);
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }


    public static Tree_Node buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public static Tree_Node build(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight)
            return null;
        int root = postorder[postRight];
        Tree_Node node = new Tree_Node(root);
        int root_posi = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == root) {
                root_posi = i;
                break;
            }
        }
        node.left = build(inorder, postorder, inLeft, root_posi - 1, postLeft, postLeft + (root_posi - inLeft) - 1);
        node.right = build(inorder, postorder, root_posi + 1, inRight, postLeft + (root_posi - inLeft), postRight - 1);
        return node;
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
