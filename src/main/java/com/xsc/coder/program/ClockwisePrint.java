package com.xsc.coder.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xia
 * @date 2020/10/11 13:58
 */
public class ClockwisePrint {

    public static void main(String[] args) {
        int[][] num = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36},
                {37, 38, 39, 40, 41, 42}
        };
        System.out.println(Arrays.toString(print(num).toArray()));
        int[][] num1 = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30}
        };
        System.out.println(Arrays.toString(print(num1).toArray()));
    }

    private static List<Integer> print(int[][] num) {
        List<Integer> list = new ArrayList<>();
        int y = num.length;
        int x = num[0].length;
        for (int i = 0; i < (int) Math.ceil(x * 1.0 / 2); i++) {
            for (int j = i; j < x - i; j++) {
                list.add(num[i][j]);
            }
            for (int j = i + 1; j < y - i; j++) {
                list.add(num[j][x - i - 1]);
            }
            for (int j = x - i - 2; j >= i; j--) {
                list.add(num[y - i - 1][j]);
            }
            for (int j = y - i - 2; j >= i + 1; j--) {
                list.add(num[j][i]);
            }
        }
        return list;
    }
}
