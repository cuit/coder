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
 * @date 2022/6/13 22:24
 */
public class LinkedListPartFlip {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode c_pre = pre;
        for (int i = 0; i < m - 1; i++) {
            c_pre = c_pre.next;
        }
        ListNode cur = c_pre.next;
        ListNode cur_next;
        for (int i = 0; i < n - m; i++) {
            cur_next = cur.next;
            cur.next = cur_next.next;
            cur_next.next = c_pre.next;
            c_pre.next = cur_next;
        }
        return pre.next;
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
        ListNode node = reverseBetween(node1, 1, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
