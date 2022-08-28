package com.xsc.coder.program.y22.m08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 描述
 * 请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图
 * <p>
 * 数据范围： 0 \le n \le 100000≤n≤10000
 * 要求： 空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * <p>
 * 如输入[1,2,4,5,3],[4,2,5,1,3]时，通过前序遍历的结果[1,2,4,5,3]和中序遍历的结果[4,2,5,1,3]可重建出以下二叉树：
 * <p>
 * 所以对应的输出为[1,3,5]。
 * 示例1
 * 输入：
 * [1,2,4,5,3],[4,2,5,1,3]
 * 复制
 * 返回值：
 * [1,3,5]
 * 复制
 * 备注：
 * 二叉树每个节点的值在区间[1,10000]内，且保证每个节点的值互不相同。
 *
 * @author xia
 * @date 2022/8/28 20:18
 */
public class SolveRightView {

    public static class TreeNode {

        int val = 0;

        TreeNode left = null;

        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 求二叉树的右视图
     *
     * @param xianxu  int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public static int[] solve(int[] xianxu, int[] zhongxu) {
        TreeNode node = buildTree(xianxu, zhongxu);
        if (node == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 弹出当前一层的所有节点
            TreeNode lastNode = null;
            List<TreeNode> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    lastNode = poll;
                    if (poll.left != null) {
                        nodeList.add(poll.left);
                    }
                    if (poll.right != null) {
                        nodeList.add(poll.right);
                    }
                }
            }
            if (lastNode != null) {
                result.add(lastNode.val);
            }
            if (nodeList.size() != 0) {
                queue.addAll(nodeList);
            }
        }
        int[] nums = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            nums[i] = result.get(i);
        }
        return nums;
    }

    private static TreeNode buildTree(int[] pre, int[] mid) {
        if (pre.length == 0 || mid.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < mid.length; i++) {
            if (pre[0] == mid[i]) {
                // 找到当前节点在中序遍历的位置节点
                node.left = buildTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(mid, 0, i));
                node.right = buildTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(mid, i + 1, mid.length));
                break;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] vin = {4, 7, 2, 1, 5, 3, 8, 6};
        int[] solve = solve(pre, vin);
        System.out.println(Arrays.toString(solve));
    }
}
