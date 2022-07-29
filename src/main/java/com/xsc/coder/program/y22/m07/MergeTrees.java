package com.xsc.coder.program.y22.m07;

/**
 * 描述
 * 已知两颗二叉树，将它们合并成一颗二叉树。合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。例如：
 * 两颗二叉树是:
 * Tree 1
 * <p>
 * <p>
 * Tree 2
 * <p>
 * 合并后的树为
 * <p>
 * 数据范围：树上节点数量满足 0 \le n \le 5000≤n≤500，树上节点的值一定在32位整型范围内。
 * 进阶：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n)
 * 示例1
 * 输入：
 * {1,3,2,5},{2,1,3,#,4,#,7}
 * 复制
 * 返回值：
 * {3,4,5,5,4,#,7}
 * 复制
 * 说明：
 * 如题面图
 * 示例2
 * 输入：
 * {1},{}
 * 复制
 * 返回值：
 * {1}
 *
 * @author xia
 * @date 2022/7/26 22:53
 */
public class MergeTrees {

    public static class TreeNode {

        int val = 0;

        TreeNode left = null;

        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param t1 TreeNode类
     * @param t2 TreeNode类
     * @return TreeNode类
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // write code here
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }
}
