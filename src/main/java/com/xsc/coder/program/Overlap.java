package com.xsc.coder.program;

import java.util.Scanner;

/**
 * 题目描述
 * 平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]), 右上角坐标为(x2[i], y2[i])。
 * <p>
 * 如果两个或者多个矩形有公共区域则认为它们是相互重叠的(不考虑边界和角落)。
 * <p>
 * 请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互重叠。
 * <p>
 * 输入描述:
 * 输入包括五行。
 * 第一行包括一个整数n(2 <= n <= 50), 表示矩形的个数。
 * 第二行包括n个整数x1[i](-10^9 <= x1[i] <= 10^9),表示左下角的横坐标。
 * 第三行包括n个整数y1[i](-10^9 <= y1[i] <= 10^9),表示左下角的纵坐标。
 * 第四行包括n个整数x2[i](-10^9 <= x2[i] <= 10^9),表示右上角的横坐标。
 * 第五行包括n个整数y2[i](-10^9 <= y2[i] <= 10^9),表示右上角的纵坐标。
 * 输出描述:
 * 输出一个正整数, 表示最多的地方有多少个矩形相互重叠,如果矩形都不互相重叠,输出1。
 * 示例1
 * 输入
 * 2
 * 0 90
 * 0 90
 * 100 200
 * 100 200
 * 输出
 * 2
 *
 * @author xia
 * @date 2020/9/12 11:13
 */
public class Overlap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] x1 = new int[n];
            int[] y1 = new int[n];
            int[] x2 = new int[n];
            int[] y2 = new int[n];
            init(scanner, n, x1);
            init(scanner, n, y1);
            init(scanner, n, x2);
            init(scanner, n, y2);
            System.out.println(process(n, x1, y1, x2, y2));
        }
    }

    private static void init(Scanner scanner, int n, int[] z) {
        for (int i = 0; i < n; i++) {
            z[i] = scanner.nextInt();
        }
    }

    private static int process(int n, int[] x1, int[] y1, int[] x2, int[] y2) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            int temp = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (x1[i] >= x1[j] && x1[i] < x2[j] && ((y1[i] >= y1[j] && y1[i] < y2[j]) || (y1[i] <= y2[j] && y2[i] >= y1[j]))) {
                    temp++;
                }
            }
            result = Math.max(result, temp);
        }
        return result;
    }

}
