package com.xsc.coder.program;

import java.util.Scanner;

/**
 * 题目描述
 * 牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
 * 牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
 * 牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。
 * 输入描述:
 * 输入包括两行
 * 第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),表示零食的数量和背包的容量。
 * 第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。
 * 输出描述:
 * 输出一个正整数, 表示牛牛一共有多少种零食放法。
 * 示例1
 * 输入
 * 3 10
 * 1 2 4
 * 输出
 * 8
 * 说明
 * 三种零食总体积小于10,于是每种零食有放入和不放入两种情况，一共有2*2*2 = 8种情况。
 *
 * @author xia
 * @date 2020/9/12 21:33
 */
public class SnackPack {

    private static long result = 1l;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int w = scanner.nextInt();
            int[] v = new int[n];
            long sum = 0L;
            for (int i = 0; i < n; i++) {
                v[i] = scanner.nextInt();
                sum += v[i];
            }
            if (sum <= w) {
                System.out.println((int) Math.pow(2, n));
            } else {
                dfs(0, w, v, n, 0);
                System.out.println(result);
            }
        }
    }

    /**
     * 深度优先遍历，存在当前零食放与不放两种情况
     */
    private static void dfs(long sum, int total, int[] v, int n, int i) {
        if (i >= n) {
            return;
        }
        if (sum > total) {
            return;
        }
        // 不放当前零食
        dfs(sum, total, v, n, i + 1);
        if (sum + v[i] <= total) {
            result++;
            // 放当前零食
            dfs(sum + v[i], total, v, n, i + 1);
        }
    }
}
