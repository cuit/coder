package com.xsc.coder.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author xia
 * @date 2020/8/1 21:34
 */
public class Test5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] positions = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                positions[i][j] = scanner.nextInt();
            }
        }
        int result = process(positions, n);
        System.out.println(result);
    }

    private static int process(int[][] positions, int n) {
        int result = Integer.MAX_VALUE;
        List<int[]> pos = pos(n);
        for (int[] ints : pos) {
            int res = 0;
            for (int j = 0; j <= ints.length; j++) {
                if (j == 0) {
                    res += positions[0][ints[j]];
                    continue;
                }
                if (j == ints.length) {
                    res += positions[ints[j - 1]][0];
                    continue;
                }
                res += positions[ints[j - 1]][ints[j]];
                if (res >= result) {
                    break;
                }
            }
            result = Math.min(result, res);
        }
        return result;
    }

    /**
     * @param n 几个位置
     * @return 全排列后
     */
    private static List<int[]> pos(int n) {
        int[] numbers = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            numbers[i] = i + 1;
        }
        List<int[]> list = new ArrayList<>();
        return fullSort(numbers, 0, numbers.length - 1, list);
    }

    /**
     * 全排列
     *
     * @param numbers 待排列的数字
     * @param start   开始位置
     * @param end     结束为止
     * @param list    存储排序结果
     * @return list
     */
    private static List<int[]> fullSort(int[] numbers, int start, int end, List<int[]> list) {
        if (start == end && !isMatch(list, numbers)) {
            int[] newNumbers = Arrays.copyOf(numbers, numbers.length);
            list.add(newNumbers);
        }
        for (int i = start; i <= end; i++) {
            int temp = numbers[start];
            numbers[start] = numbers[i];
            numbers[i] = temp;
            fullSort(numbers, start + 1, end, list);
            temp = numbers[start];
            numbers[start] = numbers[i];
            numbers[i] = temp;
        }
        return list;
    }

    /**
     * 判断是否有相同的路径 （A -> B -> C -> A 与 A -> C -> B -> A）等价
     *
     * @param list    已经添加进去的可选值
     * @param numbers 待添加进去的备选
     * @return 是否已经存在
     */
    private static boolean isMatch(List<int[]> list, int[] numbers) {
        if (list.size() == 0) {
            return false;
        }
        int len = numbers.length;
        for (int[] ints : list) {
            boolean flag = false;
            for (int i = 0; i < len / 2; i++) {
                if (ints[i] != numbers[len - i - 1]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return true;
            }
        }
        return false;
    }

}
