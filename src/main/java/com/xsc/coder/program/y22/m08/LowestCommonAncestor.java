package com.xsc.coder.program.y22.m08;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public static int lowestCommonAncestor优(TreeNode root, int p, int q) {
        List<Integer> pList = getRouteList优(root, p);
        List<Integer> qList = getRouteList优(root, q);
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
    private static List<Integer> getRouteList优(TreeNode root, int n) {
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

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @param p    int整型
     * @param q    int整型
     * @return int整型
     */
    public static int lowestCommonAncestor(TreeNode root, int p, int q) {
        // write code here
        Stack<TreeNode> pStack = new Stack<>();
        pStack.push(root);
        Stack<TreeNode> qStack = new Stack<>();
        qStack.push(root);
        List<Integer> pList = getRouteList(root, p, pStack);
        List<Integer> qList = getRouteList(root, q, qStack);
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
     * 获取从根节点到p的路径【普通二叉树树也满足】
     *
     * @param node  根节点
     * @param p     目标节点
     * @param stack 临时栈
     * @return 路径
     */
    private static List<Integer> getRouteList(TreeNode node, int p, Stack<TreeNode> stack) {
        TreeNode peek = stack.peek();
        // 如果等于，则满足
        if (peek.val == p) {
            return get(stack);
        }
        List<Integer> result = new ArrayList<>();
        // 如果当前是叶子节点
        if (peek.left == null && peek.right == null) {
            // 则弹出叶子节点
            stack.pop();
            return result;
        }
        // 当左节点不为空
        if (peek.left != null) {
            // 左节点入栈
            stack.push(peek.left);
            result = getRouteList(peek.left, p, stack);
        }
        // 如果已经满足条件，则提前返回
        if (result.size() != 0) {
            return result;
        }
        // 当右节点不为空
        if (peek.right != null) {
            // 栈中删除左节点
            stack.remove(peek.left);
            // 右节点入栈
            stack.push(peek.right);
            result = getRouteList(peek.right, p, stack);
        }
        return result;
    }

    // 把栈中元素转换成list结构
    private static List<Integer> get(Stack<TreeNode> stack) {
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(0, pop.val);
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
//        int lowestCommonAncestor = lowestCommonAncestor(node1, 0, 5);
        int lowestCommonAncestor = lowestCommonAncestor优(node1, 12, 11);
        System.out.println(lowestCommonAncestor);
    }
}
