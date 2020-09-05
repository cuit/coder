package com.xsc.coder.program;

/**
 * 链表按3个一翻转
 * 如： 1 > 2 > 3 > 4 > 5 > 6 > 7
 * 3 > 2 > 1 > 6 > 5 > 4 > 7
 *
 * @author xia
 * @date 2020/9/4 19:27
 */
public class NodeReverse {

    public static void main(String[] args) {

        Node a = new Node(1);
        Node b = new Node(2);
        a.setNext(b);
        Node c = new Node(3);
        b.setNext(c);
        Node d = new Node(4);
        c.setNext(d);
        Node e = new Node(5);
        d.setNext(e);
        Node f = new Node(6);
        e.setNext(f);
        Node g = new Node(7);
        f.setNext(g);
        g.setNext(d);
        System.out.println(isLoop(a));
        Node reverse = allReserve(a);
        System.out.println(reverse.value);
        while (reverse.next != null) {
            Node next = reverse.next;
            System.out.println(next.value);
            reverse = next;
        }
    }

    /**
     * 间隔3个一反转
     * 1 > 2 > 3 > 4 > 5 > 6 > 7
     * 3 > 2 > 1 > 6 > 5 > 4 > 7
     *
     * @param node 头结点
     * @return Node
     */
    private static Node reverse(Node node) {
        Node head = new Node(0);
        head.next = node;
        Node newHead = null;
        while (head.next != null && head.next.next != null && head.next.next.next != null) {
            Node a = head.next;
            Node b = a.next;
            Node c = b.next;
            Node next = c.next;
            head.next = c;
            if (newHead == null) {
                newHead = c;
            }
            a.next = next;
            c.next = b;
            b.next = a;
            head = a;
        }
        if (newHead == null) {
            newHead = node;
        }
        return newHead;
    }

    /**
     * 全反转
     * 1 > 2 > 3 > 4 > 5 > 6 > 7
     * 7 > 6 > 5 > 4 > 3 > 2 > 1
     *
     * @param node 头结点
     * @return Node
     */
    private static Node allReserve(Node node) {
        Node prev = null;
        while (node != null) {
            Node next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    /**
     * 判断链表是否有环 （快，慢指针）
     *
     * @param head 头结点
     * @return bool
     */
    private static boolean isLoop(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        Node a = head.next;
        Node b = head.next.next;
        while (a != null && b != null) {
            if (a == b) {
                return true;
            }
            a = a.next;
            if (b.next != null) {
                b = b.next.next;
            } else {
                b = null;
            }
        }
        return false;
    }

    private static class Node {

        private int value;

        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node setValue(int value) {
            this.value = value;
            return this;
        }

        public Node getNext() {
            return next;
        }

        public Node setNext(Node next) {
            this.next = next;
            return this;
        }
    }

}
