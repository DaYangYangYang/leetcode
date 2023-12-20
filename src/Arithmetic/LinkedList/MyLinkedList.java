package Arithmetic.LinkedList;

public class MyLinkedList {
    MyLinkedList prev;
    int val;
    MyLinkedList next;
    public MyLinkedList() {
        prev = null;
        val = 0;
        next = null;
    }

    public int get(int index) {
        MyLinkedList p = this.next;
        while (index > 0){
            if (p != null)
                p = p.next;
            else return -1;
            index--;
        }

        if (p != null)
            return p.val;
        return -1;
    }

    public void addAtHead(int val) {
        MyLinkedList p = new MyLinkedList();
        p.val = val;
        p.next = this.next;
        if (this.next != null)
            this.next.prev = p;
        p.prev = this;
        this.next = p;
        Display();
    }

    public void addAtTail(int val) {
        MyLinkedList t = new MyLinkedList();
        t.val = val;
        MyLinkedList p = this.next;
        while (p != null && p.next != null){
            p = p.next;
        }
        if (p != null){
            p.next = t;
            t.prev = p;
            Display();
            return;
        }
        this.next = t;
        t.prev = this;
        Display();
    }

    public void addAtIndex(int index, int val) {
        MyLinkedList p = this.next;
        index--;
        if (index < 0){
            p = this;
        }else{
            while (index > 0){
                if (p != null) {
                    p = p.next;
                    index--;
                }else
                    return;
            }
        }
        if (p == null)
            return;
        MyLinkedList t = new MyLinkedList();
        t.val = val;
        t.next = p.next;
        if (p.next != null){
            p.next.prev = t;
        }
        t.prev = p;
        p.next = t;
        Display();
    }

    public void deleteAtIndex(int index) {
        index--;
        MyLinkedList p = null;
        if (index < 0)
            p = this;
        else p = this.next;
        while (index > 0){
            if (p != null) {
                p = p.next;
                index--;
            } else return;
        }
        if (p == null)
            return;
        if (p.next != null)
            p.next = p.next.next;
        if (p.next != null)
            p.next.prev = p;

        Display();
    }

    public void Display(){
        MyLinkedList p = this.next;
        while (p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}
