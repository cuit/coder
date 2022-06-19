package com.xsc.coder.program.y22.m06;

/**
 * 描述
 * 给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针
 * 例如，
 * 给出的链表为: 1\to 2\to 3\to 4\to 51→2→3→4→5, n= 2n=2.
 * 删除了链表的倒数第 nn 个节点之后,链表变为1\to 2\to 3\to 51→2→3→5.
 * <p>
 * 数据范围： 链表长度 0\le n \le 10000≤n≤1000，链表中任意节点的值满足 0 \le val \le 1000≤val≤100
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * 备注：
 * 题目保证 nn 一定是有效的
 * 示例1
 * 输入：
 * {1,2},2
 * 复制
 * 返回值：
 * {2}
 *
 * @author xia
 * @date 2022/6/19 23:41
 */
public class RemoveNthFromEnd {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode originHead = pre;
        ListNode node1 = head;
        ListNode node2 = head;
        for (int i = 0; i < n; i++) {
            node2 = node2.next;
            if (node2 == null && i < n - 1) {
                return null;
            }
        }
        while (node2 != null) {
            pre = pre.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        pre.next = node1.next;
        return originHead.next;
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
        ListNode node = removeNthFromEnd(node1, 6);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
