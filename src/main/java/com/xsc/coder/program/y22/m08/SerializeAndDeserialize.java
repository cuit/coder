package com.xsc.coder.program.y22.m08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author xia
 * @date 2022/8/17 22:00
 */
public class SerializeAndDeserialize {

    public static class TreeNode {

        int val = 0;

        TreeNode left = null;

        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static String Serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        list.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                if (poll.left != null) {
                    list.add(poll.left.val);
                    queue.add(poll.left);
                } else {
                    list.add(null);
                    queue.add(null);
                }
                if (poll.right != null) {
                    list.add(poll.right.val);
                    queue.add(poll.right);
                } else {
                    list.add(null);
                    queue.add(null);
                }
            } else {
                list.add(null);
                list.add(null);
            }
        }
        // 去除最后几个null
        int index = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == null) {
                index = i;
            } else {
                break;
            }
        }
        StringBuilder string = new StringBuilder("{");
        for (int i = 0; i < index; i++) {
            if (list.get(i) == null) {
                string.append("#");
            } else {
                string.append(list.get(i));
            }
            if (i != index - 1) {
                string.append(",");
            } else {
                string.append("}");
            }
        }
        return string.toString();
    }

    public static TreeNode Deserialize(String str) {
        // 去除前后大括号
        String s = str.substring(1, str.length() - 1);
        if (s.length() == 0) {
            return null;
        }
        String[] strings = s.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i].equals("#") ? null : Integer.parseInt(strings[i]));
        }
        TreeNode root = new TreeNode(list.get(0));
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        nodeMap.put(0, root);
        for (int i = 1; i < list.size(); i++) {
            // 父节点
            int j = (i - 1) / 2;
            TreeNode currentNode = list.get(i) == null ? null : new TreeNode(list.get(i));
            if (currentNode != null) {
                TreeNode parentNode = nodeMap.get(j);
                if (i % 2 == 0) {
                    // 当前节点是右节点
                    parentNode.right = currentNode;
                } else {
                    // 当前节点是左节点
                    parentNode.left = currentNode;
                }
            }
            // 当前节点存入map
            nodeMap.put(i, currentNode);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
//        node2.right = node5;
        node3.left = node5;
        node3.right = node6;
//        node5.left = node8;
        node5.right = node7;
        System.out.println(Serialize(null));
        String s = "{1,2,3,4,#,5,6,#,#,#,#,#,7}";
        TreeNode deserialize = Deserialize("{}");
        System.out.println(deserialize);
    }
}
