package Arithmetic.LinkedList;

public class Reverse_Linke_List {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head){
        if (head == null)
            return head;
        ListNode p = new ListNode();
        p.next = head;
        head = head.next;
        p.next.next = null;
        ListNode q;
        while (head != null){
            q = head;
            head = head.next;
            q.next = p.next;
            p.next = q;
        }
        return p.next;

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
