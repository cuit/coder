package com.xsc.coder.program.y22.m07;

/**
 * 描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 数据范围：二叉树的节点数 0 \le n \le 10000≤n≤1000 ， 二叉树每个节点的值 0\le val \le 10000≤val≤1000
 * 要求： 空间复杂度 O(n)O(n) 。本题也有原地操作，即空间复杂度 O(1)O(1) 的解法，时间复杂度 O(n)O(n)
 * <p>
 * 比如：
 * 源二叉树
 * <p>
 * 镜像二叉树
 * <p>
 * 示例1
 * 输入：
 * {8,6,10,5,7,9,11}
 * 复制
 * 返回值：
 * {8,10,6,11,9,7,5}
 * 复制
 * 说明：
 * 如题面所示
 * 示例2
 * 输入：
 * {}
 * 复制
 * 返回值：
 * {}
 *
 * @author xia
 * @date 2022/7/29 21:48
 */
public class Mirror {

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
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public static TreeNode mirror(TreeNode pRoot) {
        // write code here
        if (pRoot == null) {
            return null;
        }
        TreeNode node = new TreeNode(pRoot.val);
        node.left = mirror(pRoot.right);
        node.right = mirror(pRoot.left);
        return node;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        TreeNode mirror = mirror(node1);
        System.out.println(mirror);
    }
}
