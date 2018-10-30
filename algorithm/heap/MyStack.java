package com.joeysin.paper.algorithm.heap;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Joeysin on  2018/10/18  10:20.
 * Describe：使用队列实现栈功能
 * 方法一：使用双queue，由于queue不支持getFirst(),getLast方法，所以增删查都需要while循环，使用两个ArrayQueue互相导数据
 * 方法二：使用linkedList,push()方法 使用另一个LinkedList数据结构互相导
 */
public class MyStack {
    Queue<Integer> queue = null;
    Queue<Integer> queue2 = null;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        Integer last = null;
        while (!queue.isEmpty()) {
            last = queue.peek();
            queue.poll();
            if (!queue.isEmpty()) {
                queue2.offer(last);
            }
        }
        switchQueue();
        return last;
    }

    private void switchQueue() {
        Queue<Integer> tmp = queue;
        queue = queue2;
        queue2 = tmp;
    }


    /**
     * Get the top element.
     */
    public int top() {
        Integer last = null;
        while (!queue.isEmpty()) {
            last = queue.peek();
            queue.poll();
            queue2.offer(last);
        }
        switchQueue();
        return last;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        LinkedList<Integer> temp = new LinkedList<>();
        temp.add(4);
        while (!linkedList.isEmpty()) {
            temp.add(linkedList.getLast());
            linkedList.remove(linkedList.getLast());
        }
        while(!temp.isEmpty()){
            linkedList.add(temp.poll());
        }


        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
    }
}
