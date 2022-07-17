package com.xsc.coder.program.y22.m07;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * 给定一个二叉树的根节点root，返回它的中序遍历结果。
 * <p>
 * 数据范围：树上节点数满足 0 \le n \le 10000≤n≤1000，树上每个节点的值满足 0 \le val \le 10000≤val≤1000
 * 进阶：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 示例1
 * 输入：
 * {1,2,#,#,3}
 * 复制
 * 返回值：
 * [2,3,1]
 * 复制
 * 说明：
 * <p>
 * 示例2
 * 输入：
 * {}
 * 复制
 * 返回值：
 * []
 * 复制
 * 示例3
 * 输入：
 * {1,2}
 * 复制
 * 返回值：
 * [2,1]
 * 复制
 * 说明：
 * <p>
 * 示例4
 * 输入：
 * {1,#,2}
 * 复制
 * 返回值：
 * [1,2]
 * 复制
 * 说明：
 *
 * @author xia
 * @date 2022/7/17 22:46
 */
public class InorderTraversal {

    public static class TreeNode {

        int val = 0;

        TreeNode left = null;

        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public static int[] inorderTraversal(TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        list = sort(root, list);
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static List<Integer> sort(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }
        if (node.left != null) {
            list = sort(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            list = sort(node.right, list);
        }
        return list;
    }

}
