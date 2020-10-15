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
        List<String> process = prev(a);
        System.out.println(Arrays.toString(process.toArray()));
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

    private static <T> List<T> middle(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }

        return result;
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
    }
}
