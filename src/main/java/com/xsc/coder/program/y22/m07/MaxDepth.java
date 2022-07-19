package com.xsc.coder.program.y22.m07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 描述
 * 求给定二叉树的最大深度，
 * 深度是指树的根节点到任一叶子节点路径上节点的数量。
 * 最大深度是所有叶子节点的深度的最大值。
 * （注：叶子节点是指没有子节点的节点。）
 * <p>
 * <p>
 * 数据范围：0 \le n \le 1000000≤n≤100000，树上每个节点的val满足 |val| \le 100∣val∣≤100
 * 要求： 时间复杂度 O(n)O(n)
 * 示例1
 * 输入：
 * {1,2}
 * 复制
 * 返回值：
 * 2
 * 复制
 * 示例2
 * 输入：
 * {1,2,3,4,#,#,5}
 * 复制
 * 返回值：
 * 3
 *
 * @author xia
 * @date 2022/7/19 22:24
 */
public class MaxDepth {

    public static class TreeNode {

        int val = 0;

        TreeNode left = null;

        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static class TreeNodeWithLevel {

        TreeNode node;

        int level;

        public TreeNodeWithLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

    }

    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public static int maxDepth(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        TreeNodeWithLevel rootLevel = new TreeNodeWithLevel(root, 0);
        Stack<TreeNodeWithLevel> stack = new Stack<>();
        stack.push(rootLevel);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int depth = 0;
        while (!stack.isEmpty()) {
            TreeNodeWithLevel pop = stack.pop();
            List<Integer> list = map.get(pop.level);
            if (list != null) {
                list.add(pop.node.val);
            } else {
                list = new ArrayList<>();
                list.add(pop.node.val);
                map.put(pop.level, list);
            }
            if (pop.node.right != null) {
                stack.push(new TreeNodeWithLevel(pop.node.right, pop.level + 1));
            }
            if (pop.node.left != null) {
                stack.push(new TreeNodeWithLevel(pop.node.left, pop.level + 1));
            }
            depth = Math.max(depth, pop.level + 1);
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
        int i = maxDepth(node1);
        System.out.println(i);
    }
}
