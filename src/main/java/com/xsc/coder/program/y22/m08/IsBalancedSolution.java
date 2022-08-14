package com.xsc.coder.program.y22.m08;

/**
 * 描述
 * 输入一棵节点数为 n 二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 * 样例解释：
 * <p>
 * 样例二叉树如图，为一颗平衡二叉树
 * 注：我们约定空树是平衡二叉树。
 * <p>
 * 数据范围：n \le 100n≤100,树上节点的val值满足 0 \le n \le 10000≤n≤1000
 * 要求：空间复杂度O(1)O(1)，时间复杂度 O(n)O(n)
 * 输入描述：
 * 输入一棵二叉树的根节点
 * 返回值描述：
 * 输出一个布尔类型的值
 * 示例1
 * 输入：
 * {1,2,3,4,5,6,7}
 * 复制
 * 返回值：
 * true
 * 复制
 * 示例2
 * 输入：
 * {}
 * 复制
 * 返回值：
 * true
 *
 * @author xia
 * @date 2022/8/14 18:03
 */
public class IsBalancedSolution {

    public static class TreeNode {

        int val = 0;

        TreeNode left = null;

        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isBalancedSolution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftLevel = getLevel(root.left, root.left != null ? 1 : 0);
        int rightLevel = getLevel(root.right, root.right != null ? 1 : 0);
        if (Math.abs(leftLevel - rightLevel) > 1) {
            return false;
        }
        boolean result = isBalancedSolution(root.left);
        if (!result) {
            return false;
        }
        result = isBalancedSolution(root.right);
        return result;
    }

    private static int getLevel(TreeNode node, int maxLevel) {
        if (node == null) {
            return maxLevel;
        }
        int level = maxLevel;
        if (node.left != null) {
            level = Math.max(level, getLevel(node.left, maxLevel + 1));
        }
        if (node.right != null) {
            level = Math.max(level, getLevel(node.right, maxLevel + 1));
        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        node4.left = node6;
        boolean balancedSolution = isBalancedSolution(node1);
        System.out.println(balancedSolution);
    }
}
