package com.xsc.coder.program;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 小易将n个棋子摆放在一张无限大的棋盘上。第i个棋子放在第x[i]行y[i]列。同一个格子允许放置多个棋子。每一次操作小易可以把一个棋子拿起并将其移动到原格子的上、下、左、右的任意一个格子中。小易想知道要让棋盘上出现有一个格子中至少有i(1 ≤ i ≤ n)个棋子所需要的最少操作次数.
 * 输入描述:
 * 输入包括三行,第一行一个整数n(1 ≤ n ≤ 50),表示棋子的个数
 * 第二行为n个棋子的横坐标x[i](1 ≤ x[i] ≤ 10^9)
 * 第三行为n个棋子的纵坐标y[i](1 ≤ y[i] ≤ 10^9)
 * 输出描述:
 * 输出n个整数,第i个表示棋盘上有一个格子至少有i个棋子所需要的操作数,以空格分割。行末无空格
 * <p>
 * 如样例所示:
 * 对于1个棋子: 不需要操作
 * 对于2个棋子: 将前两个棋子放在(1, 1)中
 * 对于3个棋子: 将前三个棋子放在(2, 1)中
 * 对于4个棋子: 将所有棋子都放在(3, 1)中
 * 示例1
 * 输入
 * 4
 * 1 2 4 9
 * 1 1 1 1
 * 输出
 * 0 1 3 10
 *
 * @author xia
 * @date 2020/8/25 23:43
 */
public class ChessBoard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] xs = new int[n];
            int[] ys = new int[n];
            scanner.nextLine();
            String[] xline = scanner.nextLine().split(" ");
            String[] yline = scanner.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                xs[i] = Integer.parseInt(xline[i]);
                ys[i] = Integer.parseInt(yline[i]);
            }
            int[] result = new int[n];
            Arrays.fill(result, Integer.MAX_VALUE);
            int[] distance = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        distance[k] = Math.abs(xs[k] - xs[i]) + Math.abs(ys[k] - ys[j]);
                    }
                    Arrays.sort(distance);
                    int temp = 0;
                    for (int k = 0; k < n; k++) {
                        temp += distance[k];
                        result[k] = Math.min(temp, result[k]);
                    }
                }
            }
            System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }
    }

}
