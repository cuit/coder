package com.xsc.coder.program.y22.m06;

import java.util.ArrayList;

/**
 * 描述
 * 合并 k 个升序的链表并将结果作为一个升序的链表返回其头节点。
 * <p>
 * 数据范围：节点总数满足 0 \le n \le 10^50≤n≤10
 * 5
 * ，链表个数满足 1 \le k \le 10^5 \1≤k≤10
 * 5
 * ，每个链表的长度满足 1 \le len \le 200 \1≤len≤200  ，每个节点的值满足 |val| <= 1000∣val∣<=1000
 * 要求：时间复杂度 O(nlogk)O(nlogk)
 * 示例1
 * 输入：
 * [{1,2,3},{4,5,6,7}]
 * 复制
 * 返回值：
 * {1,2,3,4,5,6,7}
 * 复制
 * 示例2
 * 输入：
 * [{1,2},{1,4,5},{6}]
 * 复制
 * 返回值：
 * {1,1,2,4,5,6}
 *
 * @author xia
 * @date 2022/6/18 21:44
 */
public class LinkedListKMerge {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        return div(lists, 0, lists.size() - 1);
    }

    public static ListNode div(ArrayList<ListNode> listNodes, int left, int right) {
        if (left > right) {
            return null;
        } else if (left == right) {
            return listNodes.get(left);
        } else {
            int mid = (left + right) / 2;
            return merge(div(listNodes, left, mid), div(listNodes, mid + 1, right));
        }
    }

    public static ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode result;
        if (node1.val <= node2.val) {
            result = node1;
            result.next = merge(node1.next, node2);
        } else {
            result = node2;
            result.next = merge(node1, node2.next);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(10);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode node = merge(node1, node5);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
