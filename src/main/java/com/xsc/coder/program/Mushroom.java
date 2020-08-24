package com.xsc.coder.program;

import java.util.Scanner;

/**
 * @author xia
 * @date 2020/8/13 23:01
 */
public class Mushroom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] points = new int[n][m];
            for (int i = 0; i < k; i++) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                points[x][y] = points[x][y] + 1;
            }
            int result = process(points, n, m);
            System.out.println(result);
        }
    }

    private static int process(int[][] points, int n, int m) {
        Temp cacl = calculation(points, n, m);
        int result = cacl.num;
        remove(points, cacl.x, cacl.y, n, m);
        cacl = calculation(points, n, m);
        return result + cacl.num;
    }

    private static Temp calculation(int[][] points, int n, int m) {
        Temp t = new Temp();
        int result = 0;
        int x = 0, y = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                int temp = points[i][j] != 0 ? 1 : 0;
                if (i - 1 >= 0) {
                    temp += points[i - 1][j] != 0 ? 1 : 0;
                }
                if (j - 1 >= 0) {
                    temp += points[i][j - 1] != 0 ? 1 : 0;
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    temp += points[i - 1][j - 1] != 0 ? 1 : 0;
                }
                if (i + 1 < n) {
                    temp += points[i + 1][j] != 0 ? 1 : 0;
                }
                if (j + 1 < m) {
                    temp += points[i][j + 1] != 0 ? 1 : 0;
                }
                if (i + 1 < n && j + 1 < m) {
                    temp += points[i + 1][j + 1] != 0 ? 1 : 0;
                }
                if (i + 1 < n && j - 1 >= 0) {
                    temp += points[i + 1][j - 1] != 0 ? 1 : 0;
                }
                if (i - 1 >= 0 && j + 1 < m) {
                    temp += points[i - 1][j + 1] != 0 ? 1 : 0;
                }
                if (temp >= result) {
                    result = temp;
                    x = i;
                    y = j;
                }
            }
        }
        t.num = result;
        t.x = x;
        t.y = y;
        return t;
    }

    private static void remove(int[][] points, int x, int y, int n, int m) {
        if (points[x][y] != 0) {
            points[x][y] -= 1;
        }
        if (x - 1 >= 0 && points[x - 1][y] != 0) {
            points[x - 1][y] -= 1;
        }
        if (y - 1 >= 0 && points[x][y - 1] != 0) {
            points[x][y - 1] -= 1;
        }
        if (x - 1 >= 0 && y - 1 >= 0 && points[x - 1][y - 1] != 0) {
            points[x - 1][y - 1] -= 1;
        }
        if (x + 1 < n && points[x + 1][y] != 0) {
            points[x + 1][y] -= 1;
        }
        if (y + 1 < m && points[x][y + 1] != 0) {
            points[x][y + 1] -= 1;
        }
        if (x + 1 < n && y + 1 < m && points[x + 1][y + 1] != 0) {
            points[x + 1][y + 1] -= 1;
        }
        if (x + 1 < n && y - 1 >= 0 && points[x + 1][y - 1] != 0) {
            points[x + 1][y - 1] -= 1;
        }
        if (x - 1 >= 0 && y + 1 < m && points[x - 1][y + 1] != 0) {
            points[x - 1][y + 1] -= 1;
        }
    }

    private static class Temp {

        private int num;

        private int x;

        private int y;

    }

}
