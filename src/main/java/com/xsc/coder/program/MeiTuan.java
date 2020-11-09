package com.xsc.coder.program;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 美团编程题
 *
 * @author xia
 * @date 2020/11/2 17:06
 */
public class MeiTuan {

    private static final Queue<Long> queue = new ConcurrentLinkedDeque<>();

    /**
     * 实现一个单机限流器，要求每秒钟只能通过100个请求。也就是限制QPS<=100。
     */
    public static boolean tryAcquire() {
        long timestamp = System.currentTimeMillis();
        queue.add(timestamp);
        if (queue.size() <= 100) {
            return true;
        } else {
            Iterator<Long> iterator = queue.iterator();
            while (iterator.hasNext()) {
                long val = iterator.next();
                if (timestamp - val >= 1000) {
                    iterator.remove();
                } else {
                    break;
                }
            }
            return queue.size() <= 100;
        }
    }

    // *****************************************************************************************************************

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class TreeNodeWithLevel {

        private final TreeNode node;

        private final int level;

        public TreeNodeWithLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    /**
     * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
     * 例如：
     * 给定的二叉树是{3,9,20,#,#,15,7},
     * <p>
     * 该二叉树层序遍历的结果是
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *
     * @param root 根节点
     * @return 层序遍历数组
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNodeWithLevel> queue = new LinkedList<>();
        queue.add(new TreeNodeWithLevel(root, 1));
        Map<Integer, List<Integer>> map = new HashMap<>();
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
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).collect(Collectors.toList());
    }

    // *****************************************************************************************************************

    public static class ListNode {
        int val;
        ListNode next = null;
    }

    /**
     * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
     * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
     * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
     * 示例1
     * 输入
     * [9,3,7],[6,3]
     * 输出
     * {1,0,0,0}
     *
     * @param head1 链表1的头结点
     * @param head2 链表2的头结点
     * @return 结果
     */
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
            // 把新生成的节点加到尾部
            result = addLast(result, node);
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
                // 加上最后一个进位节点
                node = new ListNode();
                node.val = 1;
                result = addLast(result, node);
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

    /**
     * 把新生成的节点加到尾部
     *
     * @param head    原始头结点
     * @param newNode 新节点
     * @return 新链表的头结点
     */
    private static ListNode addLast(ListNode head, ListNode newNode) {
        if (Objects.isNull(head)) {
            return newNode;
        }
        // 原始头节点
        ListNode tmp = head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = newNode;
        return tmp;
    }

    // *****************************************************************************************************************

    public static void main(String[] args) {
        testTryAcquire();
        testLevelOrder();
        testAddInList();
    }

    private static void testTryAcquire() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            boolean tryAcquire = tryAcquire();
            System.out.println("尝试获取锁:" + tryAcquire);
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testLevelOrder() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        root.left = node1;
        TreeNode node2 = new TreeNode(20);
        root.right = node2;
        TreeNode node3 = new TreeNode(15);
        node1.right = node3;
        TreeNode node4 = new TreeNode(7);
        node2.left = node4;
        TreeNode node5 = new TreeNode(12);
        node2.right = node5;
        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
    }

    private static void testAddInList() {
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

}
