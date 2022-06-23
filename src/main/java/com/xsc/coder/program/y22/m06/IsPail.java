package com.xsc.coder.program.y22.m06;

/**
 * 描述
 * 给定一个链表，请判断该链表是否为回文结构。
 * 回文是指该字符串正序逆序完全一致。
 * 数据范围： 链表节点数 0 \le n \le 10^50≤n≤10
 * 5
 * ，链表中每个节点的值满足 |val| \le 10^7∣val∣≤10
 * 7
 * <p>
 * 示例1
 * 输入：
 * {1}
 * 复制
 * 返回值：
 * true
 * 复制
 * 示例2
 * 输入：
 * {2,1}
 * 复制
 * 返回值：
 * false
 * 复制
 * 说明：
 * 2->1
 * 示例3
 * 输入：
 * {1,2,2,1}
 * 复制
 * 返回值：
 * true
 * 复制
 * 说明：
 * 1->2->2->1
 *
 * @author xia
 * @date 2022/6/23 23:34
 */
public class IsPail {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public static boolean isPail(ListNode head) {
        // write code here
        if (head == null) {
            return false;
        }
        ListNode n_h = head;
        ListNode node = head;
        ListNode copyNode = new ListNode(head.val);
        ListNode c_head = copyNode;
        int i = 1;
        while (node.next != null) {
            node = node.next;
            ListNode n = new ListNode(node.val);
            copyNode.next = n;
            copyNode = copyNode.next;
            i++;
        }
        ListNode pre = null;
        ListNode cur = c_head;
        while (cur != null) {
            ListNode cur_next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur_next;
        }
        for (int n = 0; n < i; n++) {
            int k = n_h.val;
            int p = pre.val;
            if (k != p) {
                return false;
            }
            n_h = n_h.next;
            pre = pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node4;
//        node3.next = node4;
        node4.next = node5;
        boolean pail = isPail(node1);
        System.out.println(pail);
    }
}
