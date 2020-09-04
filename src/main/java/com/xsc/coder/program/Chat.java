package com.xsc.coder.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 小云正在参与开发一个即时聊天工具，他负责其中的会话列表部分。
 *
 * 会话列表为显示为一个从上到下的多行控件，其中每一行表示一个会话，每一个会话都可以以一个唯一正整数id表示。
 *
 * 当用户在一个会话中发送或接收信息时，如果该会话已经在会话列表中，则会从原来的位置移到列表的最上方；如果没有在会话列表中，则在会话列表最上方插入该会话。
 *
 * 小云在现在要做的工作是测试，他会先把会话列表清空等待接收信息。当接收完大量来自不同会话的信息后，就输出当前的会话列表，以检查其中是否有bug。
 * 输入描述:
 * 输入的第一行为一个正整数T（T<=10），表示测试数据组数。
 * 接下来有T组数据。每组数据的第一行为一个正整数N（1<=N<=200），表示接收到信息的次数。第二行为N个正整数，按时间从先到后的顺序表示接收到信息的会话id。会话id不大于1000000000。
 * 输出描述:
 * 对于每一组数据，输出一行，按会话列表从上到下的顺序，输出会话id。
 * 相邻的会话id以一个空格分隔，行末没有空格。
 * 示例1
 * 输入
 * 3
 * 5
 * 1 2 3 4 5
 * 6
 * 1 100 1000 1000 100 1
 * 7
 * 1 6 3 3 1 8 1
 * 输出
 * 5 4 3 2 1
 * 1 100 1000
 * 1 8 3 6
 *
 * @author xia
 * @date 2020/8/31 21:07
 */
public class Chat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int t = scanner.nextInt();
            List<List<Integer>> results = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                int n = scanner.nextInt();
                Stack<Integer> stack = new Stack<>();
                for (int j = 0; j < n; j++) {
                    Integer num = scanner.nextInt();
                    stack.remove(num);
                    stack.push(num);
                }
                List<Integer> list = new ArrayList<>();
                while (!stack.isEmpty()) {
                    list.add(stack.pop());
                }
                results.add(list);
            }
            results.forEach(x -> System.out.println(x.stream().map(String::valueOf)
                    .collect(Collectors.joining(" "))));
        }
    }
}
