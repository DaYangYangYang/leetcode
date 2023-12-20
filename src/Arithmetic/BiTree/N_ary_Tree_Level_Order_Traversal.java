package Arithmetic.BiTree;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class N_ary_Tree_Level_Order_Traversal {
    public static void main(String[] args) {

    }

    public static List<List<String>> levelOrder(Node root) {
        List<List<String>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<Node> que = new LinkedBlockingDeque<>();
        que.add(root);
        while (!que.isEmpty()){
            int len = que.size();
            List<String> list = new ArrayList<>();
            while (len != 0){
                Node tmp = que.poll();
                list.add(tmp.getNodeValue());
                NodeList childNodes = tmp.getChildNodes();
                int length = childNodes.getLength();
                for (int i = 0; i < length; i++) {
                    que.add(childNodes.item(i));
                }
                len--;
            }
            result.add(list);
        }
        return result;
    }
}
