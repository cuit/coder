package com.xsc.coder.program.y23.m03;

/**
 * @author xia
 * @date 2023/3/4 17:45
 */
public class Node {

    public static class ListNode {

        private int value;

        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

    }

    /**
     * 链表整体反转
     *
     * @param root 原始头结点
     * @return 反转后的节点
     */
    public static ListNode reverse(ListNode root) {
        if (root == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode node = root;
        pre.next = root;
        ListNode cur;
        while (node.next != null) {
            cur = node.next;
            node.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return pre.next;
    }

    /**
     * 链表局部反转
     *
     * @param node 原始头结点
     * @param n    从 n 个开始
     * @param m    到 m 结束
     * @return 反转后节点
     */
    private static ListNode reverseFromNToM(ListNode node, int n, int m) {
        if (node == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode root = pre;
        pre.next = node;
        for (int i = 0; i < n - 1; i++) {
            pre = pre.next;
            if (pre == null) {
                return node;
            }
        }
        ListNode cur = pre.next;
        for (int i = 0; i < m - n; i++) {
            if (cur == null) {
                break;
            }
            ListNode cur_next = cur.next;
            if (cur_next == null) {
                break;
            }
            cur.next = cur_next.next;
            cur_next.next = pre.next;
            pre.next = cur_next;
        }
        return root.next;
    }

    /**
     * 链表全部局部反转
     *
     * @param node 原始链表
     * @param n    n个一反转
     * @return 反转后节点
     */
    private static ListNode reversePartCycle(ListNode node, int n) {
        if (node == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = node;
        ListNode origin_pre = pre;
        ListNode cur = node;
        boolean flag = false;
        while (cur.next != null) {
            ListNode copy_cur = cur;
            for (int i = 0; i < n - 1; i++) {
                if (copy_cur == null) {
                    flag = true;
                    break;
                }
                copy_cur = copy_cur.next;
            }
            if (flag) {
                break;
            }
            for (int i = 0; i < n - 1; i++) {
                ListNode cur_next = cur.next;
                cur.next = cur_next.next;
                cur_next.next = pre.next;
                pre.next = cur_next;
            }
            for (int i = 0; i < n; i++) {
                pre = pre.next;
            }
            cur = pre.next;
        }
        return origin_pre.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        ListNode reverse = reverse(node1);
//        while (reverse != null) {
//            System.out.println(reverse.value);
//            reverse = reverse.next;
//        }
//        ListNode node = reverseFromNToM(node1, 6, 10);
        ListNode node = reversePartCycle(node1, 2);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

}
