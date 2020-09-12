package com.xsc.coder.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            List<Integer> x = new ArrayList<>();
            List<Integer> y = new ArrayList<>();
            init(scanner, n, x1, x);
            init(scanner, n, y1, y);
            init(scanner, n, x2, x);
            init(scanner, n, y2, y);
            System.out.println(process(n, x1, y1, x2, y2, x, y));
        }
    }

    private static void init(Scanner scanner, int n, int[] z, List<Integer> list) {
        for (int i = 0; i < n; i++) {
            z[i] = scanner.nextInt();
            list.add(z[i]);
        }
    }

    private static int process(int n, int[] x1, int[] y1, int[] x2, int[] y2, List<Integer> x, List<Integer> y) {
        x = x.stream().distinct().sorted().collect(Collectors.toList());
        y = y.stream().distinct().sorted().collect(Collectors.toList());
        int result = 0;
        for (int i = 0; i < x.size() - 1; i++) {
            int tempX = 0;
            for (int j = 0; j < y.size() - 1; j++) {
                int tempY = 0;
                for (int k = 0; k < n; k++) {
                    if (isCover(x.get(i), y.get(j), x.get(i + 1), y.get(j + 1), x1[k], y1[k], x2[k], y2[k])) {
                        tempY++;
                    }
                }
                tempX = Math.max(tempX, tempY);
            }
            result = Math.max(result, tempX);
        }
        return result;
    }

    private static boolean isCover(int x1, int y1, int x2, int y2, int m1, int n1, int m2, int n2) {
        return x1 >= m1 && x2 <= m2 && y1 >= n1 && y2 <= n2;
    }

}
