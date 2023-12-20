package Arithmetic.LinkedList;

public class Swap_Nodes_in_Pairs {

    public static void main(String[] args) {

    }

    public static ListNode swapPairs(ListNode head){
        if (head == null)
            return head;
        ListNode h = new ListNode();
        h.next = head;
        ListNode p = h;
        while (p != null && p.next != null && p.next.next != null){
            ListNode q = p.next;
            ListNode t = q.next;
            q.next = t.next;
            p.next = t;
            t.next = q;
            p = p.next.next;

        }

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
