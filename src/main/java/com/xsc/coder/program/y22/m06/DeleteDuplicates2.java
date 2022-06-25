package com.xsc.coder.program.y22.m06;

/**
 * 描述
 * 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 * 例如：
 * 给出的链表为1 \to 2\to 3\to 3\to 4\to 4\to51→2→3→3→4→4→5, 返回1\to 2\to51→2→5.
 * 给出的链表为1\to1 \to 1\to 2 \to 31→1→1→2→3, 返回2\to 32→3.
 * <p>
 * 数据范围：链表长度 0 \le n \le 100000≤n≤10000，链表中的值满足 |val| \le 1000∣val∣≤1000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 进阶：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * 示例1
 * 输入：
 * {1,2,2}
 * 复制
 * 返回值：
 * {1}
 * 复制
 * 示例2
 * 输入：
 * {}
 * 复制
 * 返回值：
 * {}
 *
 * @author xia
 * @date 2022/6/25 20:49
 */
public class DeleteDuplicates2 {

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
        ListNode pre = new ListNode(Integer.MAX_VALUE);
        ListNode origin_pre = pre;
        pre.next = head;
        ListNode cur = pre.next;
        while (cur != null) {
            ListNode cur_next = cur.next;
            boolean flag = false;
            while (cur_next != null && cur_next.val == cur.val) {
                cur = cur.next;
                cur_next = cur_next.next;
                flag = true;
            }
            if (flag) {
                pre.next = cur_next;
                cur = pre.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return origin_pre.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
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
