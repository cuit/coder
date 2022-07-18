package com.xsc.coder.program.y22.m07;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * 给定一个二叉树，返回他的后序遍历的序列。
 * <p>
 * 后序遍历是值按照 左节点->右节点->根节点 的顺序的遍历。
 * <p>
 * 数据范围：二叉树的节点数量满足 0 \le n \le 100 \0≤n≤100  ，二叉树节点的值满足 1 \le val \le 100 \1≤val≤100  ，树的各节点的值各不相同
 * <p>
 * 样例图
 * <p>
 * <p>
 * 示例1
 * 输入：
 * {1,#,2,3}
 * 复制
 * 返回值：
 * [3,2,1]
 * 复制
 * 说明：
 * 如题面图
 * 示例2
 * 输入：
 * {1}
 * 复制
 * 返回值：
 * [1]
 *
 * @author xia
 * @date 2022/7/18 22:19
 */
public class PostOrderTraversal {

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
    public static int[] postOrderTraversal(TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        list = sort(root, list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
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
        if (node.right != null) {
            list = sort(node.right, list);
        }
        list.add(node.val);
        return list;
    }
}
