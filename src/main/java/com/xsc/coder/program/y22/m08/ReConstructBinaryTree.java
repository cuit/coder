package com.xsc.coder.program.y22.m08;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * 给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建出如下图所示。
 * <p>
 * <p>
 * 提示:
 * 1.vin.length == pre.length
 * 2.pre 和 vin 均无重复元素
 * 3.vin出现的元素均出现在 pre里
 * 4.只需要返回根结点，系统会自动输出整颗树做答案对比
 * 数据范围：n \le 2000n≤2000，节点的值 -10000 \le val \le 10000−10000≤val≤10000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 示例1
 * 输入：
 * [1,2,4,7,3,5,6,8],[4,7,2,1,5,3,8,6]
 * 复制
 * 返回值：
 * {1,2,3,4,#,5,6,#,7,#,#,8}
 * 复制
 * 说明：
 * 返回根节点，系统会输出整颗二叉树对比结果，重建结果如题面图示
 * 示例2
 * 输入：
 * [1],[1]
 * 复制
 * 返回值：
 * {1}
 * 复制
 * 示例3
 * 输入：
 * [1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
 * 复制
 * 返回值：
 * {1,2,5,3,4,6,7}
 *
 * @author xia
 * @date 2022/8/18 23:11
 */
public class ReConstructBinaryTree {

    public static class TreeNode {

        int val = 0;

        TreeNode left = null;

        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        if (pre.length == 0) {
            return null;
        }
        int rootVal = pre[0];
        TreeNode root = new TreeNode(rootVal);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        buildNode(root, pre, vin, list);
        return root;
    }

    private static void buildNode(TreeNode node, int[] pre, int[] vin, List<Integer> list) {
        if (list.size() == pre.length) {
            return;
        }
        // 根节点的值
        int rootVal = pre[0];
        // 获取中间节点的下标
        int middleIndex = getIndex(vin, rootVal);
        // 获取当前节点在中序遍历的位置
        int index = getIndex(vin, node.val);
        // 当前节点在前序遍历的位置
        int currentIndex = getIndex(pre, node.val);
        if (index < middleIndex) {
            // 寻找左节点
            for (int i = currentIndex + 1; i < pre.length; i++) {
                if (list.contains(i)) {
                    continue;
                }
                // 判断当前节点的值是否在中序遍历的对应节点的左边
                if (getIndex(vin, pre[i]) < index) {
                    list.add(i);
                    node.left = new TreeNode(pre[i]);
                    break;
                }
            }
            // 寻找右节点
            for (int i = currentIndex + 1; i < pre.length; i++) {
                if (list.contains(i)) {
                    continue;
                }
                int temp = getIndex(vin, pre[i]);
                if (temp > index && temp < middleIndex) {
                    list.add(i);
                    node.right = new TreeNode(pre[i]);
                    break;
                }
            }
        } else if (index > middleIndex) {
            for (int i = currentIndex + 1; i < pre.length; i++) {
                if (list.contains(i)) {
                    continue;
                }
                // 判断当前节点的值是否在中序遍历的对应节点的左边
                int temp = getIndex(vin, pre[i]);
                if (temp < index && temp > middleIndex) {
                    list.add(i);
                    node.left = new TreeNode(pre[i]);
                    break;
                }
            }
            // 寻找右节点
            for (int i = currentIndex + 1; i < pre.length; i++) {
                if (list.contains(i)) {
                    continue;
                }
                // 判断当前节点的值是否在中序遍历的对应节点的左边
                int temp = getIndex(vin, pre[i]);
                if (temp > index) {
                    list.add(i);
                    node.right = new TreeNode(pre[i]);
                    break;
                }
            }
        } else {
            // 当前节点是根节点
            // 寻找左节点
            for (int i = currentIndex + 1; i < pre.length; i++) {
                if (list.contains(i)) {
                    continue;
                }
                // 判断当前节点的值是否在中序遍历的对应节点的左边
                if (getIndex(vin, pre[i]) < index) {
                    list.add(i);
                    node.left = new TreeNode(pre[i]);
                    break;
                }
            }
            // 寻找右节点
            for (int i = currentIndex + 1; i < pre.length; i++) {
                if (list.contains(i)) {
                    continue;
                }
                if (getIndex(vin, pre[i]) > index) {
                    list.add(i);
                    node.right = new TreeNode(pre[i]);
                    break;
                }
            }
        }
        if (node.right != null) {
            buildNode(node.right, pre, vin, list);
        }
        if (node.left != null) {
            buildNode(node.left, pre, vin, list);
        }
    }

    private static int getIndex(int[] nums, int value) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] vin = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = reConstructBinaryTree(pre, vin);
        System.out.println(treeNode);
    }

}
