package com.xsc.coder.program.y22.m08;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 1.对于该题的最近的公共祖先定义:对于有根树T的两个节点p、q，最近公共祖先LCA(T,p,q)表示一个节点x，满足x是p和q的祖先且x的深度尽可能大。在这里，一个节点也可以是它自己的祖先.
 * 2.二叉搜索树是若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值； 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值
 * 3.所有节点的值都是唯一的。
 * 4.p、q 为不同节点且均存在于给定的二叉搜索树中。
 * 数据范围:
 * 3<=节点总数<=10000
 * 0<=节点值<=10000
 * <p>
 * 如果给定以下搜索二叉树: {7,1,12,0,4,11,14,#,#,3,5}，如下图:
 * <p>
 * <p>
 * 示例1
 * 输入：
 * {7,1,12,0,4,11,14,#,#,3,5},1,12
 * 复制
 * 返回值：
 * 7
 * 复制
 * 说明：
 * 节点1 和 节点12的最近公共祖先是7
 * 示例2
 * 输入：
 * {7,1,12,0,4,11,14,#,#,3,5},12,11
 * 复制
 * 返回值：
 * 12
 * 复制
 * 说明：
 * 因为一个节点也可以是它自己的祖先.所以输出12
 *
 * @author xia
 * @date 2022/8/14 18:39
 */
public class LowestCommonAncestor {

    public static class TreeNode {

        int val = 0;

        TreeNode left = null;

        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 【优】
     *
     * @param root 根节点
     * @param p    p节点
     * @param q    q节点
     * @return 最近公共祖先
     */
    public static int lowestCommonAncestor(TreeNode root, int p, int q) {
        List<Integer> pList = getRouteList(root, p);
        List<Integer> qList = getRouteList(root, q);
        int num = Math.min(pList.size(), qList.size());
        int result = root.val;
        for (int i = 0; i < num; i++) {
            if (pList.get(i).equals(qList.get(i))) {
                result = pList.get(i);
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * 利用【搜索二叉树】的特点：左节点一定小于根节点，右节点一定大于根节点
     *
     * @param root 根节点
     * @return 到达n的经过的节点
     */
    private static List<Integer> getRouteList(TreeNode root, int n) {
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        while (node != null) {
            list.add(node.val);
            if (node.val == n) {
                break;
            }
            if (n > node.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(14);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        int lowestCommonAncestor = lowestCommonAncestor(node1, 0, 5);
        System.out.println(lowestCommonAncestor);
    }
}
