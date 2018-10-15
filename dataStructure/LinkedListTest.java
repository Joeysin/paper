package com.joeysin.paper.dataStructure;

public class LinkedListTest {

    public static class Node {
        private Object data;
        public Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Object data) {
            this.data = data;
        }
    }

    /**
     * Created by Joeysin on  2018/10/12  19:01.
     * Describe：反转链表
     */
    public static Node reverseList(Node head) {
        Node prev = null;
        Node now = null;
        while (head != null) {
            now = head;
            head = head.next;
            now.next = prev;
            prev = now;
        }
        return prev;
    }

    /**
     * Created by Joeysin on  2018/10/12  18:59.
     * Describe：奇偶链表
     */
    public static Node oddEvenList(Node head) {
        Node odd = head;//奇数
        Node even = head.next;//偶数
        Node t = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = t;
        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        Node node1 = oddEvenList(node);
        while (node1.next != null) {
            System.out.println(node1.data);
            node1 = node1.next;
        }
    }
}
