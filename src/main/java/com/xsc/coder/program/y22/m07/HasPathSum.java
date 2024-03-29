package com.xsc.coder.program.y22.m07;

/**
 * 描述
 * 给定一个二叉树root和一个值 sum ，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径。
 * 1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
 * 2.叶子节点是指没有子节点的节点
 * 3.路径只能从父节点到子节点，不能从子节点到父节点
 * 4.总节点数目为n
 * <p>
 * 例如：
 * 给出如下的二叉树，\ sum=22 sum=22，
 * <p>
 * 返回true，因为存在一条路径 5\to 4\to 11\to 25→4→11→2的节点值之和为 22
 * <p>
 * 数据范围：
 * 1.树上的节点数满足 0 \le n \le 100000≤n≤10000
 * 2.每 个节点的值都满足 |val| \le 1000∣val∣≤1000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 进阶：空间复杂度 O(树的高度)O(树的高度)，时间复杂度 O(n)O(n)
 * 示例1
 * 输入：
 * {5,4,8,1,11,#,9,#,#,2,7},22
 * 复制
 * 返回值：
 * true
 * 复制
 * 示例2
 * 输入：
 * {1,2},0
 * 复制
 * 返回值：
 * false
 * 复制
 * 示例3
 * 输入：
 * {1,2},3
 * 复制
 * 返回值：
 * true
 * 复制
 * 示例4
 * 输入：
 * {},0
 * 复制
 * 返回值：
 * false
 *
 * @author xia
 * @date 2022/7/19 22:42
 */
public class HasPathSum {

    public static class TreeNode {

        int val = 0;

        TreeNode left = null;

        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return bool布尔型
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        // write code here
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        }
        boolean result = false;
        if (root.left != null) {
            result = result || hasPathSum(root.left, sum - root.val);
        }
        if (root.right != null) {
            result = result || hasPathSum(root.right, sum - root.val);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(11);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node5.left = node7;
        node5.right = node8;
        System.out.println(hasPathSum(node1, 10));
    }
}
