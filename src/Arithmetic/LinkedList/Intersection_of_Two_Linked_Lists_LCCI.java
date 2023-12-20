package Arithmetic.LinkedList;

public class Intersection_of_Two_Linked_Lists_LCCI {
    public static void main(String[] args) {

    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if (headA == null || headB == null)
            return null;
        ListNode p = headA;
        while (p.next != null){
            p = p.next;
        }
        ListNode h = p;
        p.next = headA;

        p = headB;
        ListNode q = headB;
        while (q != null){
            p = p.next;
            q = q.next;
            if (q != null)
                q = q.next;
            else {
                h.next = null;
                return null;
            }
            if (p == q)
                break;
        }
        if (q == null) {
            h.next = null;
            return null;
        }
        p = headB;
        while (p != q){
            p = p.next;
            q = q.next;
        }
        h.next = null;
        return p;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        if (headA == null || headB == null)
            return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
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
