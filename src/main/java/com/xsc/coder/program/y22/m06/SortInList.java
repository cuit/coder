package com.xsc.coder.program.y22.m06;

/**
 * 描述
 * 给定一个节点数为n的无序单链表，对其按升序排序。
 * <p>
 * 数据范围：0 < n \le 1000000<n≤100000
 * 要求：时间复杂度 O(nlogn)O(nlogn)
 * <p>
 * 示例1
 * 输入：
 * {1,3,2,4,5}
 * 复制
 * 返回值：
 * {1,2,3,4,5}
 * 复制
 * 示例2
 * 输入：
 * {-1,0,-2}
 * 复制
 * 返回值：
 * {-2,-1,0}
 *
 * @author xia
 * @date 2022/6/20 23:55
 */
public class SortInList {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public static ListNode sortInList(ListNode head) {
        // write code here
        ListNode originPre = new ListNode(Integer.MAX_VALUE);
        originPre.next = head;
        ListNode sort = originPre;
        while (sort.next != null) {
            ListNode pre = sort;
            ListNode cur = pre.next;
            ListNode min = null;
            ListNode pre_min = null;
            while (cur != null) {
                if (min == null || cur.val < min.val) {
                    min = cur;
                    pre_min = pre;
                }
                cur = cur.next;
                pre = pre.next;
            }
            pre_min.next = min.next;
            min.next = sort.next;
            sort.next = min;
            sort = min;
        }
        return originPre.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = sortInList(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
