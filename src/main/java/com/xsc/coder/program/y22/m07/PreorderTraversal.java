package com.xsc.coder.program.y22.m07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * 数据范围：二叉树的节点数量满足 0 \le n \le 100 \0≤n≤100  ，二叉树节点的值满足 1 \le val \le 100 \1≤val≤100  ，树的各节点的值各不相同
 * 示例 1：
 * <p>
 * <p>
 * 示例1
 * 输入：
 * {1,#,2,3}
 * 复制
 * 返回值：
 * [1,2,3]
 *
 * @author xia
 * @date 2022/7/17 22:32
 */
public class PreorderTraversal {

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
    public static int[] preorderTraversal(TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        list = process(root, list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static List<Integer> process(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }
        list.add(node.val);
        if (node.left != null) {
            list = process(node.left, list);
        }
        if (node.right != null) {
            list = process(node.right, list);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        int[] ints = preorderTraversal(node1);
        System.out.println(Arrays.toString(ints));
    }
}
