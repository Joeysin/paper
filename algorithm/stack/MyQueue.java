package com.joeysin.paper.algorithm.stack;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by Joeysin on  2018/10/18  11:29.
 * Describe：用栈实现队列
 */
public class MyQueue {

    Stack<Integer> stack = null;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack = new Stack<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack.remove(0);
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack.get(0);
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.add(2);
        stack.add(1);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add("a");
        stack.add("b");
        System.out.println(stack.peek());
        System.out.println(stack.remove(0));

    }
}
