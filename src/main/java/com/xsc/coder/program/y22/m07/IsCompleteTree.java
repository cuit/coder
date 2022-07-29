package com.xsc.coder.program.y22.m07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 描述
 * 给定一个二叉树，确定他是否是一个完全二叉树。
 * <p>
 * 完全二叉树的定义：若二叉树的深度为 h，除第 h 层外，其它各层的结点数都达到最大个数，第 h 层所有的叶子结点都连续集中在最左边，这就是完全二叉树。（第 h 层可能包含 [1~2h] 个节点）
 * <p>
 * 数据范围：节点数满足 1 \le n \le 100 \1≤n≤100
 * 样例图1：
 * <p>
 * 样例图2：
 * <p>
 * 样例图3：
 * <p>
 * 示例1
 * 输入：
 * {1,2,3,4,5,6}
 * 复制
 * 返回值：
 * true
 * 复制
 * 示例2
 * 输入：
 * {1,2,3,4,5,6,7}
 * 复制
 * 返回值：
 * true
 * 复制
 * 示例3
 * 输入：
 * {1,2,3,4,5,#,6}
 * 复制
 * 返回值：
 * false
 *
 * @author xia
 * @date 2022/7/29 22:13
 */
public class IsCompleteTree {

    public static class TreeNode {

        int val = 0;

        TreeNode left = null;

        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static class TreeNodeWithLevel {

        private TreeNode node;

        private int level;

        public TreeNodeWithLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public static boolean isCompleteTree(TreeNode root) {
        // write code here
        if (root == null) {
            return false;
        }
        Map<Integer, List<TreeNodeWithLevel>> map = new HashMap<>();
        TreeNodeWithLevel nodeWithLevel = new TreeNodeWithLevel(root, 0);
        List<TreeNodeWithLevel> list = new ArrayList<>();
        list.add(nodeWithLevel);
        map.put(0, list);
        Queue<TreeNodeWithLevel> queue = new LinkedList<>();
        queue.add(nodeWithLevel);
        while (!queue.isEmpty()) {
            TreeNodeWithLevel poll = queue.poll();
            TreeNode node = poll.node;
            if (node.left != null) {
                List<TreeNodeWithLevel> levels = map.get(poll.level + 1);
                TreeNodeWithLevel withLevel = new TreeNodeWithLevel(node.left, poll.level + 1);
                if (levels == null) {
                    List<TreeNodeWithLevel> levels1 = new ArrayList<>();
                    levels1.add(withLevel);
                    map.put(poll.level + 1, levels1);
                } else {
                    levels.add(withLevel);
                }
                queue.add(withLevel);
            }
            if (node.right != null) {
                List<TreeNodeWithLevel> levels = map.get(poll.level + 1);
                TreeNodeWithLevel withLevel = new TreeNodeWithLevel(node.right, poll.level + 1);
                if (levels == null) {
                    List<TreeNodeWithLevel> levels1 = new ArrayList<>();
                    levels1.add(withLevel);
                    map.put(poll.level + 1, levels1);
                } else {
                    levels.add(withLevel);
                }
                queue.add(withLevel);
            }
        }
        Set<Map.Entry<Integer, List<TreeNodeWithLevel>>> entries = map.entrySet();
        List<Map.Entry<Integer, List<TreeNodeWithLevel>>> listEntry = new ArrayList<>(entries);
        listEntry.sort(Comparator.comparingInt(Map.Entry::getKey));
        // 获取倒数第二层
        int i = listEntry.size() - 2;
        if (i < 0) {
            return true;
        }
        Map.Entry<Integer, List<TreeNodeWithLevel>> integerListEntry = listEntry.get(i);
        if (integerListEntry == null) {
            return false;
        }
        List<TreeNodeWithLevel> value = integerListEntry.getValue();
        if (value.size() != Math.pow(2, i)) {
            return false;
        }
        int m = 0;
        for (int k = value.size() - 1; k >= 0; k--) {
            TreeNodeWithLevel withLevel = value.get(k);
            TreeNode node = withLevel.node;
            if (node.right != null) {
                m = k;
                if (node.left == null) {
                    return false;
                }
                break;
            }
            if (node.left != null) {
                m = k;
                break;
            }
        }
        for (int k = m - 1; k >= 0; k--) {
            TreeNodeWithLevel withLevel = value.get(k);
            TreeNode node = withLevel.node;
            if (node.left == null || node.right == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
        boolean completeTree = isCompleteTree(node1);
        System.out.println(completeTree);
    }
}
