package com.xsc.coder.program.y22.m07;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * 给定一个二叉树根节点，请你判断这棵树是不是二叉搜索树。
 * <p>
 * 二叉搜索树满足每个节点的左子树上的所有节点均严格小于当前节点且右子树上的所有节点均严格大于当前节点。
 * <p>
 * 例：
 * <p>
 * 图1
 * <p>
 * 图2
 * <p>
 * 数据范围：节点数量满足 1 \le n\le 10^4 \1≤n≤10
 * 4
 * ，节点上的值满足 -2^{31} \le val \le 2^{31}-1\−2
 * 31
 * ≤val≤2
 * 31
 * −1
 * 示例1
 * 输入：
 * {1,2,3}
 * 复制
 * 返回值：
 * false
 * 复制
 * 说明：
 * 如题面图1
 * 示例2
 * 输入：
 * {2,1,3}
 * 复制
 * 返回值：
 * true
 * 复制
 * 说明：
 * 如题面图2
 *
 * @author xia
 * @date 2022/7/29 21:57
 */
public class IsValidBST {

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
     * @return bool布尔型
     */
    public static boolean isValidBST(TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        middleSort(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static void middleSort(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            middleSort(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            middleSort(node.right, list);
        }
    }
}
