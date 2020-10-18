package com.xsc.coder.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author xia
 * @date 2020/10/15 11:21
 */
public class Tree {

    public static void main(String[] args) {
        TreeNode<String> a = new TreeNode<>("a");
        TreeNode<String> b = new TreeNode<>("b");
        a.setLeft(b);
        TreeNode<String> c = new TreeNode<>("c");
        a.setRight(c);
        TreeNode<String> d = new TreeNode<>("d");
        b.setLeft(d);
        TreeNode<String> e = new TreeNode<>("e");
        b.setRight(e);
        TreeNode<String> f = new TreeNode<>("f");
        c.setRight(f);
        TreeNode<String> g = new TreeNode<>("g");
        d.setLeft(g);
        TreeNode<String> h = new TreeNode<>("h");
        d.setRight(h);
        TreeNode<String> i = new TreeNode<>("i");
        f.setLeft(i);
        TreeNode<String> j = new TreeNode<>("j");
        i.setRight(j);
        TreeNode<String> k = new TreeNode<>("k");
        c.setLeft(k);
        List<String> process = prev(a);
        System.out.println(Arrays.toString(process.toArray()));
        process = middle(a);
        System.out.println(Arrays.toString(process.toArray()));
        process = next(a);
        System.out.println(Arrays.toString(process.toArray()));
        TreeNode<String> reverse = reverse(a);
        System.out.println(reverse);
    }

    /**
     * 根 -> 左 -> 右
     * 前序遍历
     */
    private static <T> List<T> prev(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<T> pop = stack.pop();
            result.add((T) pop.getValue());
            if (Objects.nonNull(pop.getRight())) {
                stack.push(pop.getRight());
            }
            if (Objects.nonNull(pop.getLeft())) {
                stack.push(pop.getLeft());
            }
        }
        return result;
    }

    /**
     * 中序遍历
     * 左 -> 根 -> 右
     */
    private static <T> List<T> middle(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> tmp = root;
        while (Objects.nonNull(tmp)) {
            stack.push(tmp);
            tmp = tmp.getLeft();
        }
        while (!stack.isEmpty()) {
            TreeNode<T> pop = stack.pop();
            result.add(pop.getValue());
            tmp = pop.getRight();
            if (Objects.nonNull(tmp)) {
                stack.push(tmp);
                while (tmp.getLeft() != null) {
                    stack.push(tmp.getLeft());
                    tmp = tmp.getLeft();
                }
            }
        }
        return result;
    }

    /**
     * 后序遍历
     * 左 -> 右 -> 根
     */
    private static <T> List<T> next(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        TreeNode<T> tmp = root;
        Stack<TreeNode<T>> stack = new Stack<>();
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.getLeft();
        }
        List<TreeNode<T>> visit = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode<T> peek = stack.peek();
            if (peek.getRight() == null) {
                result.add(peek.getValue());
                visit.add(peek);
                stack.pop();
                continue;
            }
            tmp = peek.getRight();
            if (visit.contains(tmp)) {
                result.add(peek.getValue());
                visit.add(peek);
                stack.pop();
                continue;
            }
            if (tmp != null) {
                stack.push(tmp);
                while (tmp.getLeft() != null) {
                    stack.push(tmp.getLeft());
                    tmp = tmp.getLeft();
                }
            }
        }
        return result;
    }

    /**
     * 树按中轴反转
     *          a                 a
     *       b     c    ->     c      b
     */
    private static <T> TreeNode<T> reverse(TreeNode<T> root) {
        if (root == null || (root.getLeft() == null) && root.getRight() == null) {
            return root;
        }
        TreeNode<T> left = reverse(root.getLeft());
        TreeNode<T> right = reverse(root.getRight());
        root.setLeft(right);
        root.setRight(left);
        return root;
    }

    private static class TreeNode<T> {

        private T value;

        private TreeNode<T> left;

        private TreeNode<T> right;

        public TreeNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public TreeNode<T> getLeft() {
            return left;
        }

        public TreeNode<T> setLeft(TreeNode<T> left) {
            this.left = left;
            return this;
        }

        public TreeNode<T> getRight() {
            return right;
        }

        public TreeNode<T> setRight(TreeNode<T> right) {
            this.right = right;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode<?> treeNode = (TreeNode<?>) o;
            return Objects.equals(value, treeNode.value) &&
                    Objects.equals(left, treeNode.left) &&
                    Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, left, right);
        }
    }
}
