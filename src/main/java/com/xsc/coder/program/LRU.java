package com.xsc.coder.program;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author xia
 * @date 2020/10/17 20:52
 */
public class LRU {

    private LinkedList<Node> dataList;

    private int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
        dataList = new LinkedList<Node>();
    }

    private void put(int key, int value) {
        Iterator<Node> iterator = dataList.iterator();
        while (iterator.hasNext()) {
            Node next = iterator.next();
            if (next.key == key) {
                // 删除旧的
                iterator.remove();
                break;
            }
        }
        if (dataList.size() >= capacity) {
            // 删除链表尾部
            dataList.removeLast();
        }
        dataList.addFirst(new Node(key, value));
    }

    private int get(int key) {
        Iterator<Node> iterator = dataList.iterator();
        int result = -1;
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (key == node.key) {
                result = node.value;
                iterator.remove();
                dataList.addFirst(node);
                break;
            }
        }
        return result;
    }

    class Node {

        private int key;

        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
