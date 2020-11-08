package com.xsc.coder.program;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

/**
 * 实现一个单机限流器，要求每秒钟只能通过100个请求。也就是限制QPS<=100。
 *
 * @author xia
 * @date 2020/11/2 17:06
 */
public class MeiTuan {

    private static Queue<Long> queue = new ConcurrentLinkedDeque<>();

    public static boolean tryAcquire() {
        long timestamp = System.currentTimeMillis();
        queue.add(timestamp);
        if (queue.size() <= 100) {
            return true;
        } else {
            Iterator<Long> iteator = queue.iterator();
            while (iteator.hasNext()) {
                long val = iteator.next();
                if (timestamp - val >= 1000) {
                    iteator.remove();
                } else {
                    break;
                }
            }
            return queue.size() <= 100;
        }
    }

    //给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
    //例如：
    //给定的二叉树是{3,9,20,#,#,15,7},
    //
    //该二叉树层序遍历的结果是
    //[
    //[3],
    //[9,20],
    //[15,7]
    //]
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNodeWithLevel> queue = new LinkedList<>();
        queue.add(new TreeNodeWithLevel(root, 1));
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap();
        while (!queue.isEmpty()) {
            TreeNodeWithLevel nodeWithLevel = queue.poll();
            if (map.containsKey(nodeWithLevel.level)) {
                map.get(nodeWithLevel.level).add(nodeWithLevel.node.val);
            } else {
                map.put(nodeWithLevel.level, Lists.newArrayList(nodeWithLevel.node.val));
            }
            if (nodeWithLevel.node.right != null) {
                queue.add(new TreeNodeWithLevel(nodeWithLevel.node.right, nodeWithLevel.level + 1));
            }
            if (nodeWithLevel.node.left != null) {
                queue.add(new TreeNodeWithLevel(nodeWithLevel.node.left, nodeWithLevel.level + 1));
            }
        }
        return map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue).collect(Collectors.toList());
    }

    private static class TreeNodeWithLevel {

        private TreeNode node;

        private int level;

        public TreeNodeWithLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode();
        root1.val = 9;
        ListNode child1 = new ListNode();
        child1.val = 3;
        ListNode child2 = new ListNode();
        child2.val = 7;
        root1.next = child1;
        child1.next = child2;
        ListNode root2 = new ListNode();
        root2.val = 6;
        ListNode child3 = new ListNode();
        child3.val = 3;
        root2.next = child3;
        ListNode result = addInList(root1, root2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    // 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
    //给定两个这种链表，请生成代表两个整数相加值的结果链表。
    //例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
    //示例1
    //输入
    //[9,3,7],[6,3]
    //输出
    //{1,0,0,0}
    public static ListNode addInList(ListNode head1, ListNode head2) {
        // 反转第一个节点 7 -> 3 -> 9
        ListNode reverserNode1 = reverse(head1);
        // 反转第二个节点 3 -> 6
        ListNode reverserNode2 = reverse(head2);
        // 存储最终结果
        ListNode result = null;
        // 当前两个节点相加是否进位标志位
        boolean flag = false;
        while (reverserNode1 != null || reverserNode2 != null) {
            ListNode node = new ListNode();
            int val = (reverserNode1 != null ? reverserNode1.val : 0)
                    + (reverserNode2 != null ? reverserNode2.val : 0);
            // 如果上一次运算后有进位，那么本次就需要把本次运算的结果和进位相加
            if (flag) {
                // 加上进位
                val += 1;
                // 重置标志位
                flag = false;
            }
            // 如果运算后的结果大于9，那么需要进位
            if (val > 9) {
                flag = true;
                node.val = val - 10;
            } else {
                node.val = val;
            }
            ListNode tmp;
            if (Objects.isNull(result)) {
                result = node;
            } else {
                // tmp零时存储头结点
                tmp = result;
                while (result.next != null) {
                    result = result.next;
                }
                // 把新生成的节点加在尾部
                result.next = node;
                // 重置result为头结点
                result = tmp;
            }
            // reverserNode1向后移动一个节点
            if (Objects.nonNull(reverserNode1)) {
                reverserNode1 = reverserNode1.next;
            }
            // reverserNode2向后移动一个节点
            if (Objects.nonNull(reverserNode2)) {
                reverserNode2 = reverserNode2.next;
            }
            // 如果reverserNode1和reverserNode2节点都为空，说明是都移动到最后一位了，并且还有进位
            if (Objects.isNull(reverserNode1) && Objects.isNull(reverserNode2) && flag) {
                tmp = result;
                while (result.next != null) {
                    result = result.next;
                }
                // 加上最后一个进位节点
                node = new ListNode();
                node.val = 1;
                result.next = node;
                result = tmp;
            }
        }
        // 反转节点
        result = reverse(result);
        return result;
    }

    /**
     * 链表反转
     *
     * @param node 当前头结点
     * @return 反转后的头结点
     */
    private static ListNode reverse(ListNode node) {
        // 前驱节点
        ListNode prev = null;
        // 反转后的头结点
        ListNode head = node;
        while (node != null) {
            // 每次存储最后一个不为空的节点，既是反转后的头结点
            head = node;
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next = null;
    }
}
