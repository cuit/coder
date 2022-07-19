package com.xsc.coder.program.y22.m07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 描述
 * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 * <p>
 * 数据范围：0 \le n \le 15000≤n≤1500,树上每个节点的val满足 |val| <= 1500∣val∣<=1500
 * 要求：空间复杂度：O(n)O(n)，时间复杂度：O(n)O(n)
 * 例如：
 * 给定的二叉树是{1,2,3,#,#,4,5}
 * <p>
 * 该二叉树之字形层序遍历的结果是
 * [
 * [1],
 * [3,2],
 * [4,5]
 * ]
 * 示例1
 * 输入：
 * {1,2,3,#,#,4,5}
 * 复制
 * 返回值：
 * [[1],[3,2],[4,5]]
 * 复制
 * 说明：
 * 如题面解释，第一层是根节点，从左到右打印结果，第二层从右到左，第三层从左到右。
 * 示例2
 * 输入：
 * {8,6,10,5,7,9,11}
 * 复制
 * 返回值：
 * [[8],[10,6],[5,7,9,11]]
 * 复制
 * 示例3
 * 输入：
 * {1,2,3,4,5}
 * 复制
 * 返回值：
 * [[1],[3,2],[4,5]]
 *
 * @author xia
 * @date 2022/7/19 21:54
 */
public class PrintZhiLevelOrder {

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
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        TreeNodeWithLevel rootLevel = new TreeNodeWithLevel(root, 0);
        Stack<TreeNodeWithLevel> stack = new Stack<>();
        stack.push(rootLevel);
        Map<Integer, List<Integer>> map = new HashMap<>();
        while (!stack.isEmpty()) {
            TreeNodeWithLevel pop = stack.pop();
            List<Integer> list = map.get(pop.level);
            if (list != null) {
                if (pop.level % 2 != 0) {
                    list.add(0, pop.node.val);
                } else {
                    list.add(pop.node.val);
                }
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
        }
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(entries);
        list.sort(new Comparator<Map.Entry<Integer, List<Integer>>>() {
            @Override
            public int compare(Map.Entry<Integer, List<Integer>> o1, Map.Entry<Integer, List<Integer>> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        for (Map.Entry<Integer, List<Integer>> entry : list) {
            result.add((ArrayList<Integer>) entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        ArrayList<ArrayList<Integer>> arrayLists = levelOrder(node1);
        for (ArrayList<Integer> arrayList : arrayLists) {
            System.out.println(arrayList.toString());
        }
    }
}
