package com.xsc.coder.program.y22.m06;

/**
 * 描述
 * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
 * 例如：
 * 给出的链表为1\to1\to21→1→2,返回1 \to 21→2.
 * 给出的链表为1\to1\to 2 \to 3 \to 31→1→2→3→3,返回1\to 2 \to 31→2→3.
 * <p>
 * 数据范围：链表长度满足 0 \le n \le 1000≤n≤100，链表中任意节点的值满足 |val| \le 100∣val∣≤100
 * 进阶：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * 示例1
 * 输入：
 * {1,1,2}
 * 复制
 * 返回值：
 * {1,2}
 * 复制
 * 示例2
 * 输入：
 * {}
 * 复制
 * 返回值：
 * {}
 *
 * @author xia
 * @date 2022/6/25 20:41
 */
public class DeleteDuplicates {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.val != pre.val) {
                cur = cur.next;
                pre = pre.next;
                continue;
            }
            pre.next = cur.next;
            cur = pre.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = deleteDuplicates(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
