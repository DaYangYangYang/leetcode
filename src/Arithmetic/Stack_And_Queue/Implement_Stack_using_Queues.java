package Arithmetic.Stack_And_Queue;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Implement_Stack_using_Queues {

    public static void main(String[] args) {
        MyStack2 myStack= new MyStack2();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(2);
        int top = myStack.top();
        System.out.println(top);
        int pop = myStack.pop();
        System.out.println(pop);
        top = myStack.top();
        System.out.println(top);


    }
}

class MyStack {

    Queue<Integer> in;
    Queue<Integer> out;

    public MyStack() {
        this.in = new LinkedBlockingDeque<>();
        this.out = new LinkedBlockingDeque<>();
    }

    public void push(int x) {
        in.add(x);
    }

    public int pop() {
        while (in.size() > 1){
            out.add(in.remove());
        }
        int peek = in.remove();
        while (!out.isEmpty()){
            in.add(out.remove());
        }
        return peek;
    }

    public int top() {
        while (in.size() > 1){
            out.add(in.remove());
        }
        int peek = in.remove();
        out.add(peek);
        while (!out.isEmpty()){
            in.add(out.remove());
        }
        return peek;
    }

    public boolean empty() {
        if (in.isEmpty())
            return true;
        return false;
    }
}

class MyStack2 {

    Queue<Integer> in;

    public MyStack2() {
        this.in = new LinkedBlockingDeque<>();
    }

    public void push(int x) {
        in.add(x);
    }

    public int pop() {
        int size = in.size();
        while (size > 1){
            in.add(in.remove());
            size--;
        }
        return in.remove();
    }

    public int top() {
        int size = in.size();
        while (size > 1){
            in.add(in.remove());
            size--;
        }
        int peek = in.remove();
        in.add(peek);
        return peek;
    }

    public boolean empty() {
        if (in.isEmpty())
            return true;
        return false;
    }
}
class MyStack3 {

    Queue<Integer> que1;
    Queue<Integer> que2;

    public MyStack3() {
        this.que1 = new LinkedBlockingDeque<>();
        this.que2 = new LinkedBlockingDeque<>();
    }

    public void push(int x) {
        que2.add(x);
        while (!que1.isEmpty()){
            que2.add(que1.remove());
        }
        Queue<Integer> que = que1;
        que1 = que2;
        que2 = que;
    }

    public int pop() {
        return que1.remove();
    }

    public int top() {
        return que1.peek();
    }

    public boolean empty() {
        return que1.isEmpty();
    }
}