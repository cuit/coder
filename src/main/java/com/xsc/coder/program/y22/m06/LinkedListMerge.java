package com.xsc.coder.program.y22.m06;

/**
 * 描述
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 数据范围： 0 \le n \le 10000≤n≤1000，-1000 \le 节点值 \le 1000−1000≤节点值≤1000
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * <p>
 * 如输入{1,3,5},{2,4,6}时，合并后的链表为{1,2,3,4,5,6}，所以对应的输出为{1,2,3,4,5,6}，转换过程如下图所示：
 * <p>
 * <p>
 * 或输入{-1,2,4},{1,3,4}时，合并后的链表为{-1,1,2,3,4,4}，所以对应的输出为{-1,1,2,3,4,4}，转换过程如下图所示：
 * <p>
 * 示例1
 * 输入：
 * {1,3,5},{2,4,6}
 * 复制
 * 返回值：
 * {1,2,3,4,5,6}
 * 复制
 * 示例2
 * 输入：
 * {},{}
 * 复制
 * 返回值：
 * {}
 * 复制
 * 示例3
 * 输入：
 * {-1,2,4},{1,3,4}
 * 复制
 * 返回值：
 * {-1,1,2,3,4,4}
 *
 * @author xia
 * @date 2022/6/15 21:54
 */
public class LinkedListMerge {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            return m(list1, list2);
        }
        return m(list2, list1);
    }

    public static ListNode m(ListNode node1, ListNode node2) {
        ListNode pre = new ListNode(-99999);
        pre.next = node1;
        ListNode originPre = pre;
        ListNode curNo1 = node1;
        ListNode curNo2 = node2;
        while (curNo1 != null) {
            while (curNo2.val < curNo1.val) {
                pre.next = curNo2;
                ListNode tmp = curNo2.next;
                curNo2.next = curNo1;
                pre = pre.next;
                curNo2 = tmp;
                if (curNo2 == null) {
                    break;
                }
            }
            if (curNo2 == null) {
                break;
            }
            curNo1 = curNo1.next;
            pre = pre.next;
            if (curNo1 == null) {
                pre.next = curNo2;
            }
        }
        return originPre.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(10);
        ListNode node4 = new ListNode(20);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(7);
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
