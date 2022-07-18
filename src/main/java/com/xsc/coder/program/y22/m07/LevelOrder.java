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
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7},
 * <p>
 * 该二叉树层序遍历的结果是
 * [
 * [3],
 * [9,20],
 * [15,7]
 * <p>
 * ]
 * <p>
 * <p>
 * 数据范围：二叉树的节点数满足 1 \le n \le 10^5 \1≤n≤10
 * 5
 * <p>
 * <p>
 * <p>
 * 示例1
 * 输入：
 * {1,2}
 * 复制
 * 返回值：
 * [[1],[2]]
 * 复制
 * 示例2
 * 输入：
 * {1,2,3,4,#,#,5}
 * 复制
 * 返回值：
 * [[1],[2,3],[4,5]]
 *
 * @author xia
 * @date 2022/7/18 22:47
 */
public class LevelOrder {

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
}
