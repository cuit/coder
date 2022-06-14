package com.xsc.coder.program.y22.m06;

/**
 * 描述
 * 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * <p>
 * 数据范围： \ 0 \le n \le 2000 0≤n≤2000 ， 1 \le k \le 20001≤k≤2000 ，链表中每个元素都满足 0 \le val \le 10000≤val≤1000
 * 要求空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * 例如：
 * 给定的链表是 1\to2\to3\to4\to51→2→3→4→5
 * 对于 k = 2k=2 , 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
 * 对于 k = 3k=3 , 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5
 * <p>
 * 示例1
 * 输入：
 * {1,2,3,4,5},2
 * 复制
 * 返回值：
 * {2,1,4,3,5}
 * 复制
 * 示例2
 * 输入：
 * {},1
 * 复制
 * 返回值：
 * {}
 *
 * @author xia
 * @date 2022/6/14 22:02
 */
public class LinkedListPartKFlip {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        int i = 0;
        ListNode cp = head;
        while (cp != null) {
            i++;
            if (i % k == 0) {
                head = reverse(head, i - k + 1, i);
                for (int j = 0; j < k; j++) {
                    if (cp == null) {
                        break;
                    }
                    cp = cp.next;
                }
            } else {
                cp = cp.next;
            }
        }
        return head;
    }

    private static ListNode reverse(ListNode head, int m, int n) {
        ListNode origin_pre = new ListNode(-1);
        origin_pre.next = head;
        ListNode pre = origin_pre;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode cur_next;
        for (int i = 0; i < n - m; i++) {
            cur_next = cur.next;
            cur.next = cur_next.next;
            cur_next.next = pre.next;
            pre.next = cur_next;
        }
        return origin_pre.next;
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
        ListNode node = reverseKGroup(node1, 3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
