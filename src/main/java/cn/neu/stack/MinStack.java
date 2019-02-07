package cn.neu.stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> min;
    Stack<Integer> data;

    public MinStack() {
        min = new Stack<>();
        data = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (min.isEmpty() || min.peek() > x)
            min.push(x);
        else
            min.push(min.peek());
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());;
        System.out.println(minStack.getMin());
        ;
    }
}
