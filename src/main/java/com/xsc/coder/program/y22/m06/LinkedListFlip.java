package com.xsc.coder.program.y22.m06;

/**
 * 描述
 * 将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)。
 * 例如：
 * 给出的链表为 1\to 2 \to 3 \to 4 \to 5 \to NULL1→2→3→4→5→NULL, m=2,n=4m=2,n=4,
 * 返回 1\to 4\to 3\to 2\to 5\to NULL1→4→3→2→5→NULL.
 * <p>
 * 数据范围： 链表长度 0 < size \le 10000<size≤1000，0 < m \le n \le size0<m≤n≤size，链表中每个节点的值满足 |val| \le 1000∣val∣≤1000
 * 要求：时间复杂度 O(n)O(n) ，空间复杂度 O(n)O(n)
 * 进阶：时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)
 * 示例1
 * 输入：
 * {1,2,3,4,5},2,4
 * 复制
 * 返回值：
 * {1,4,3,2,5}
 * 复制
 * 示例2
 * 输入：
 * {5},1,1
 * 复制
 * 返回值：
 * {5}
 *
 * @author xia
 * @date 2022/6/13 22:14
 */
public class LinkedListFlip {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode head_next;
        while (head != null && head.next != null) {
            head_next = head.next;
            head.next = head_next.next;
            head_next.next = pre.next;
            pre.next = head_next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = reverseList(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
