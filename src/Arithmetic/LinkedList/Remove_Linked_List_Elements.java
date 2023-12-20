package Arithmetic.LinkedList;

import java.util.Arrays;

public class Remove_Linked_List_Elements {
    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head= createLinkedList(nums);
        head = removeElements(head, 6);
        Display(head);
    }

    public static void Display(ListNode head){
        ListNode n = head;
        while (n != null){
            System.out.print(n.val + " ");
            n = n.next;
        }
    }


    public static ListNode removeElements(ListNode head, int val){
        if (head == null)
            return head;
        ListNode pre = head;
        while (pre != null){
            if (pre.val == val) {
                head = head.next;
                pre = null;
                pre = head;
            }else break;
        }
        ListNode p = head;
        if (pre != null) {
            pre = pre.next;
        }
        while (pre != null){
            if (pre.val == val){
                p.next = pre.next;
                pre = null;
                pre = p.next;
            }else{
                pre = pre.next;
                p = p.next;
            }
        }

        return head;
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
