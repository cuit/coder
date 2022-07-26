package com.xsc.coder.program.y22.m07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述
 * 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
 * 例如：                                 下面这棵二叉树是对称的
 * <p>
 * 下面这棵二叉树不对称。
 * <p>
 * 数据范围：节点数满足 0 \le n \le 10000≤n≤1000，节点上的值满足 |val| \le 1000∣val∣≤1000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 备注：
 * 你可以用递归和迭代两种方法解决这个问题
 * 示例1
 * 输入：
 * {1,2,2,3,4,4,3}
 * 复制
 * 返回值：
 * true
 * 复制
 * 示例2
 * 输入：
 * {8,6,9,5,7,7,5}
 * 复制
 * 返回值：
 * false
 *
 * @author xia
 * @date 2022/7/26 22:35
 */
public class IsSymmetrical {

    public static class TreeNode {

        int val = 0;

        TreeNode left = null;

        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot.left);
        queue.add(pRoot.right);
        while (!queue.isEmpty()) {
            TreeNode poll1 = queue.poll();
            TreeNode poll2 = queue.poll();
            if (poll1 != null && poll2 != null) {
                if (poll1.val == poll2.val) {
                    queue.add(poll1.left);
                    queue.add(poll2.right);
                    queue.add(poll1.right);
                    queue.add(poll2.left);
                } else {
                    return false;
                }
            } else if (poll1 != null) {
                return false;
            } else if (poll2 != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
//        TreeNode node6 = new TreeNode(3);
//        TreeNode node7 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;
//        node3.left = node6;
//        node3.right = node7;
        boolean symmetrical = isSymmetrical(node1);
        System.out.println(symmetrical);
    }
}
