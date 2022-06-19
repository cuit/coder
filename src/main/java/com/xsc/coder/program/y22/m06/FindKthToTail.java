package com.xsc.coder.program.y22.m06;

/**
 * 描述
 * 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 * <p>
 * <p>
 * 数据范围：0 \leq n \leq 10^50≤n≤10
 * 5
 * ，0 \leq a_i \leq 10^90≤a
 * i
 * ​
 * ≤10
 * 9
 * ，0 \leq k \leq 10^90≤k≤10
 * 9
 * <p>
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 进阶：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * <p>
 * 例如输入{1,2,3,4,5},2时，对应的链表结构如下图所示：
 * <p>
 * 其中蓝色部分为该链表的最后2个结点，所以返回倒数第2个结点（也即结点值为4的结点）即可，系统会打印后面所有的节点来比较。
 * 示例1
 * 输入：
 * {1,2,3,4,5},2
 * 复制
 * 返回值：
 * {4,5}
 * 复制
 * 说明：
 * 返回倒数第2个节点4，系统会打印后面所有的节点来比较。
 * 示例2
 * 输入：
 * {2},8
 * 复制
 * 返回值：
 * {}
 *
 * @author xia
 * @date 2022/6/19 23:27
 */
public class FindKthToTail {

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
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public static ListNode findKthToTail(ListNode pHead, int k) {
        // write code here
        if (pHead == null) {
            return null;
        }
        ListNode node1 = pHead;
        ListNode node2 = pHead;
        for (int i = 0; i < k; i++) {
            node2 = node2.next;
            if (node2 == null && i < k - 1) {
                return null;
            }
        }
        while (node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
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
        ListNode node = findKthToTail(node1, 6);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
