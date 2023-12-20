package Arithmetic.LinkedList;

public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 获取
     * @return val
     */
    public int getVal() {
        return val;
    }

    /**
     * 设置
     * @param val
     */
    public void setVal(int val) {
        this.val = val;
    }

    /**
     * 获取
     * @return next
     */
    public ListNode getNext() {
        return next;
    }

    /**
     * 设置
     * @param next
     */
    public void setNext(ListNode next) {
        this.next = next;
    }

    public String toString() {
        return "LinkedList{val = " + val + ", next = " + next + "}";
    }
}
