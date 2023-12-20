package Arithmetic.Stack_And_Queue;

import java.util.Stack;

public class Implement_Queue_using_Stacks {
    public static void main(String[] args) {

    }
}
class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        while (!out.empty()){
            in.push(out.pop());
        }
        in.push(x);
    }

    public int pop() {
        while (!in.empty()){
            out.push(in.pop());
        }
        return out.pop();
    }

    public int peek() {
        while (!in.empty()){
            out.push(in.pop());
        }
        return out.peek();
    }

    public boolean empty() {
        if (in.empty() && out.empty())
            return true;
        return false;
    }
}
