package com.xsc.coder.program;

import java.util.Scanner;

/**
 * 题目描述
 * 给定5个正整数, 它们的最小的众倍数是指的能够被其中至少三个数整除的最小正整数。 给定5个不同的正整数, 请计算输出它们的最小众倍数。
 * 输入描述:
 * 输入包括一行,一行中有五个各不相同的正整数a, b, c, d, e(1 ≤ a, b, c, d, e ≤ 100), 以空格分割
 * 输出描述:
 * 输出一个整数,表示它们的最小众倍数
 * 示例1
 * 输入
 * 1 2 3 4 5
 * 输出
 * 4
 *
 * @author xia
 * @date 2020/9/13 21:16
 */
public class Multiple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            int e = scanner.nextInt();
            int[] num = new int[]{a, b, c, d, e};
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < num.length - 2; i++) {
                for (int j = i + 1; j < num.length - 1; j++) {
                    for (int k = j + 1; k < num.length; k++) {
                        result = Math.min(result, cacl(num[i], num[j], num[k]));
                    }
                }
            }
            System.out.println(result);
        }
    }

    /**
     * 计算3个数的最小公倍数
     */
    private static int cacl(int a, int b, int c) {
        int ab = a * b / cacl(a, b);
        return ab * c / cacl(ab, c);
    }

    /**
     * 求最小公倍数 辗转相除法
     * a = 10 b = 12
     * 10 % 12 = 10
     * 12 % 10 = 2
     * 10 % 2 = 0
     */
    private static int cacl(int a, int b) {
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}
