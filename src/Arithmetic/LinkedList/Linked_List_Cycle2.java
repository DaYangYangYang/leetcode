package Arithmetic.LinkedList;

import java.util.List;

public class Linked_List_Cycle2 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 0, 4};
        ListNode head = createLinkedList(nums);
        ListNode p = head;
        p = p.next.next.next;
        p.next = head.next;
        System.out.println(detectCycle(head));

    }

    public static ListNode detectCycle(ListNode head){
        if (head == null)
            return head;
        ListNode p = head;
        ListNode q = head;

        while (true){
            p = p.next;
            if (q != null)
                q = q.next;
            else return null;
            if (q != null)
                q = q.next;
            else return null;
            if(p == q)
                break;
        }

        p = head;
        while (p != q){
            p = p.next;
            q = q.next;
        }

        return p;
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
