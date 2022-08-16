package com.xsc.coder.program.y22.m08;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 描述
 * 给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 * <p>
 * 数据范围：树上节点数满足 1 \le n \le 10^5 \1≤n≤10
 * 5
 * , 节点值val满足区间 [0,n)
 * 要求：时间复杂度 O(n)O(n)
 * <p>
 * 注：本题保证二叉树中每个节点的val值均不相同。
 * <p>
 * 如当输入{3,5,1,6,2,0,8,#,#,7,4},5,1时，二叉树{3,5,1,6,2,0,8,#,#,7,4}如下图所示：
 * <p>
 * 所以节点值为5和节点值为1的节点的最近公共祖先节点的节点值为3，所以对应的输出为3。
 * 节点本身可以视为自己的祖先
 * 示例1
 * 输入：
 * {3,5,1,6,2,0,8,#,#,7,4},5,1
 * 复制
 * 返回值：
 * 3
 * 复制
 * 示例2
 * 输入：
 * {3,5,1,6,2,0,8,#,#,7,4},2,7
 * 复制
 * 返回值：
 * 2
 *
 * @author xia
 * @date 2022/8/17 0:02
 */
public class lowestCommonAncestorV2 {

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
}
