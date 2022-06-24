package com.xsc.coder.program.y22.m06;

/**
 * 描述
 * 给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
 * 注意是节点的编号而非节点的数值。
 * <p>
 * 数据范围：节点数量满足 0 \le n \le 10^50≤n≤10
 * 5
 * ，节点中的值都满足 0 \le val \le 10000≤val≤1000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 示例1
 * 输入：
 * {1,2,3,4,5,6}
 * 复制
 * 返回值：
 * {1,3,5,2,4,6}
 * 复制
 * 说明：
 * 1->2->3->4->5->6->NULL
 * 重排后为
 * 1->3->5->2->4->6->NULL
 * <p>
 * 示例2
 * 输入：
 * {1,4,6,3,7}
 * 复制
 * 返回值：
 * {1,6,7,4,3}
 * 复制
 * 说明：
 * 1->4->6->3->7->NULL
 * 重排后为
 * 1->6->7->4->3->NULL
 * 奇数位节点有1,6,7，偶数位节点有4,3。重排后为1,6,7,4,3
 * <p>
 * 备注：
 * 链表长度不大于200000。每个数范围均在int内。
 *
 * @author xia
 * @date 2022/6/24 22:46
 */
public class OddEvenList {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode oddEvenList(ListNode head) {
        // 先分成两个队列
        if (head == null) {
            return null;
        }
        ListNode node1 = new ListNode(-1);
        node1.next = head;
        ListNode node2 = new ListNode(-1);
        ListNode splitNode2 = node2;
        ListNode splitNode1 = node1;
        while (splitNode1 != null) {
            ListNode preNode = splitNode1;
            ListNode curNode = splitNode1.next;
            if (curNode == null) {
                break;
            }
            preNode = preNode.next;
            curNode = curNode.next;
            if (curNode == null) {
                break;
            }
            ListNode tmp = curNode.next;
            curNode.next = null;
            splitNode2.next = curNode;
            splitNode2 = splitNode2.next;
            preNode.next = tmp;
            splitNode1 = preNode;
        }
        ListNode n_1 = node1.next;
        ListNode n_2 = node2.next;
        n_1 = sort(n_1);
        n_2 = sort(n_2);
        ListNode merge_node = n_1;
        while (merge_node.next != null) {
            merge_node = merge_node.next;
        }
        merge_node.next = n_2;
        return n_1;
    }

    private static ListNode sort(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        dummyNode.next = node;
        ListNode sortNode = dummyNode;
        while (sortNode.next != null) {
            ListNode pre = sortNode;
            ListNode curNode = pre.next;
            ListNode min = null;
            ListNode min_pre = null;
            while (curNode != null) {
                if (min == null || curNode.val < min.val) {
                    min = curNode;
                    min_pre = pre;
                }
                curNode = curNode.next;
                pre = pre.next;
            }
            min_pre.next = min.next;
            min.next = sortNode.next;
            sortNode.next = min;
            sortNode = min;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = oddEvenList(node1);
//        ListNode node = sort(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
