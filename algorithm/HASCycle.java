package com.joeysin.paper.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Joeysin on  2018/10/15  15:03.
 * Describe：判断是否循环链表
 */
public class HasCycle {
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
     * Created by Joeysin on  2018/10/15  15:03.
     * Describe：使用set结构记录节点，如果存在说明是循环链表
     */
    public static boolean hasCycle(Node head) {
        Set<Node> set = new HashSet();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }


    /**
     * Created by Joeysin on  2018/10/15  15:03.
     * Describe：使用快慢指针，如果重合，说明是循环链表
     */
    public static boolean hasCycle2(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head.next;
        while (head != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
