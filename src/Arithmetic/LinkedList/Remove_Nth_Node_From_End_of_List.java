package Arithmetic.LinkedList;

import java.util.ArrayList;

public class Remove_Nth_Node_From_End_of_List {

    public static void main(String[] args) {

    }



    public static ListNode removeNthFromEnd(ListNode head, int n){
        if (head == null)
            return head;

        ListNode h = new ListNode();
        h.next = head;
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null){
            list.add(p);
            p = p.next;
        }
        int num = list.size() - (n + 1);
        if (num < -1)
            return head;
        if (num == -1)
            p = h;
        else p = list.get(num);
        if (p.next != null)
            p.next = p.next.next;

        return h.next;

    }




    //创建一个链表
    public static ListNode createLinkedList(int[] nums){
        ListNode pre = new ListNode();
        ListNode next = pre;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i], null);
            next.next = node;
            next = node;
        }
        return pre.next;
    }
}
