package com.xsc.coder.program;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 从右边看向一个树，打印出来
 * A
 * B     C
 * D    E
 * F
 * 输出; A C E F
 *
 * @author xia
 * @date 2020/10/14 16:39
 */
public class TreeRightPrint {

    public static void main(String[] args) {
        TreeNode a = new TreeNode("a");
        TreeNode b = new TreeNode("b");
        a.setLeft(b);
        TreeNode c = new TreeNode("c");
        a.setRight(c);
        TreeNode d = new TreeNode("d");
        b.setLeft(d);
        TreeNode e = new TreeNode("e");
        b.setRight(e);
        TreeNode f = new TreeNode("f");
        d.setRight(f);
        List<String> process = process(a);
        System.out.println(process.stream().collect(Collectors.joining(" -> ")));
    }

    private static List<String> process(TreeNode root) {
        Queue<TreeNodeWithLevel> quene = new LinkedList<>();
        quene.add(new TreeNodeWithLevel(root, 0));
        Map<Integer, String> map = new HashMap<>();
        while (!quene.isEmpty()) {
            TreeNodeWithLevel poll = quene.poll();
            TreeNode treeNode = poll.getTreeNode();
            map.put(poll.getLevel(), treeNode.getValue());
            if (treeNode.getLeft() != null) {
                quene.add(new TreeNodeWithLevel(treeNode.getLeft(), poll.getLevel() + 1));
            }
            if (treeNode.getRight() != null) {
                quene.add(new TreeNodeWithLevel(treeNode.getRight(), poll.getLevel() + 1));
            }
        }
        return map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue).collect(Collectors.toList());
    }

    private static class TreeNodeWithLevel {

        private TreeNode treeNode;

        private int level;

        public TreeNodeWithLevel(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }

        public TreeNode getTreeNode() {
            return treeNode;
        }

        public int getLevel() {
            return level;
        }
    }

    private static class TreeNode implements Serializable {

        private String value;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public TreeNode setValue(String value) {
            this.value = value;
            return this;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode setLeft(TreeNode left) {
            this.left = left;
            return this;
        }

        public TreeNode getRight() {
            return right;
        }

        public TreeNode setRight(TreeNode right) {
            this.right = right;
            return this;
        }
    }
}
