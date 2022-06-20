package com.xsc.coder.program.y22.m06;

/**
 * 描述
 * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 数据范围：0 \le n,m \le 10000000≤n,m≤1000000，链表任意值 0 \le val \le 90≤val≤9
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * <p>
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 * <p>
 * 示例1
 * 输入：
 * [9,3,7],[6,3]
 * 复制
 * 返回值：
 * {1,0,0,0}
 * 复制
 * 说明：
 * 如题面解释
 * 示例2
 * 输入：
 * [0],[6,3]
 * 复制
 * 返回值：
 * {6,3}
 * 复制
 * 备注：
 * 1 \leq n, m \leq 10^61≤n,m≤10
 * 6
 * <p>
 * 0 \leq a_i, b_i \leq 90≤a
 * i
 * ​
 * ,b
 * i
 * ​
 * ≤9
 *
 * @author xia
 * @date 2022/6/20 22:53
 */
public class AddInList {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public static ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        ListNode revNode1 = reverse(head1);
        ListNode revNode2 = reverse(head2);
        ListNode revResult = add(revNode1, revNode2);
        return reverse(revResult);
    }

    private static ListNode add(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        int i = 0;
        int j = 0;
        ListNode tmp1 = node1;
        ListNode tmp2 = node2;
        while (tmp1 != null) {
            i++;
            tmp1 = tmp1.next;
        }
        while (tmp2 != null) {
            j++;
            tmp2 = tmp2.next;
        }
        tmp1 = node1;
        tmp2 = node2;
        ListNode result = new ListNode(-1);
        ListNode pre = result;
        // 是否进位的标志
        boolean flag = false;
        for (int n = 0; n < Math.min(i, j); n++) {
            int val1 = tmp1.val;
            int val2 = tmp2.val;
            int tmpVal = val1 + val2;
            if (flag) {
                tmpVal += 1;
            }
            ListNode node;
            if (tmpVal >= 10) {
                flag = true;
                node = new ListNode(tmpVal - 10);
            } else {
                flag = false;
                node = new ListNode(tmpVal);
            }
            pre.next = node;
            pre = pre.next;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        for (int n = 0; n < Math.abs(j - i); n++) {
            if (i < j) {
                int val = tmp2.val;
                if (flag) {
                    val += 1;
                }
                ListNode node;
                if (val >= 10) {
                    flag = true;
                    node = new ListNode(val - 10);
                } else {
                    flag = false;
                    node = new ListNode(val);
                }
                pre.next = node;
                pre = pre.next;
                tmp2 = tmp2.next;
            } else {
                int val = tmp1.val;
                if (flag) {
                    val += 1;
                }
                ListNode node;
                if (val >= 10) {
                    flag = true;
                    node = new ListNode(val - 10);
                } else {
                    flag = false;
                    node = new ListNode(val);
                }
                pre.next = node;
                pre = pre.next;
                tmp1 = tmp1.next;
            }
        }
        if (flag) {
            ListNode node = new ListNode(1);
            pre.next = node;
        }
        return result.next;
    }

    private static ListNode reverse(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = node;
        ListNode cur_next;
        while (node.next != null) {
            cur_next = node.next;
            node.next = cur_next.next;
            cur_next.next = pre.next;
            pre.next = cur_next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(7);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

//        ListNode node10 = new ListNode(2);
        ListNode node20 = new ListNode(6);
        ListNode node30 = new ListNode(3);
//        ListNode node40 = new ListNode(5);
//        ListNode node50 = new ListNode(6);
//        node10.next = node20;
        node20.next = node30;
//        node30.next = node40;
//        node40.next = node50;

        ListNode node = addInList(node1, node20);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
