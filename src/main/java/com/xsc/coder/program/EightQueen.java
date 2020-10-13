package com.xsc.coder.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 八皇后算法描述如下：在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法！
 * <p>
 * 关键点：回溯法
 *
 * @author xia
 * @date 2020/10/13 20:56
 */
public class EightQueen {

    public static void main(String[] args) {
        process(8);
    }

    private static void process(int n) {
        List<String[][]> result = new ArrayList<>();
        String[][] queen = new String[n][n];
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                queen[i][j] = "*";
                map[i][j] = 0;
            }
        }
        seek(0, n, map, queen, result);
        System.out.println(result.size());
        for (String[][] strings : result) {
            for (String[] string : strings) {
                System.out.println(Arrays.toString(string));
            }
            System.out.println("----------------------");
        }
    }

    /**
     * @param k      查找第k行
     * @param n      N皇后问题
     * @param map    目前棋盘上已占位置的所有攻击范围
     * @param queen  皇后所在位子
     * @param result 最终结果
     */
    private static void seek(int k, int n, int[][] map, String[][] queen, List<String[][]> result) {
        // K能到最后一行，说明有解
        if (k == n) {
            // 把结果copy出来，避免后续操作覆盖
            String[][] newMap = copy(queen);
            result.add(newMap);
            return;
        }
        for (int i = 0; i < n; i++) {
            // 当前位置还可以放一个皇后位置
            if (map[k][i] == 0) {
                int[][] tmp = copy(map);
                // 标注位置
                queen[k][i] = "Q";
                // 渲染当前点所能辐射所有方向的位置
                attack(k, i, map);
                // 继续查找下一行
                seek(k + 1, n, map, queen, result);
                // 如果不满足，回溯
                queen[k][i] = "*";
                map = tmp;
            }
        }
    }

    /**
     * 渲染当前点的八个方向的位置
     *
     * @param i   i
     * @param j   j
     * @param map map
     */
    private static void attack(int i, int j, int[][] map) {
        int n = map.length;
        // 把 map 数组中八个方向上的数据都修改掉
        int tmpi = i, tmpj = j;
        // 上
        while (tmpi - 1 >= 0) {
            map[tmpi - 1][tmpj] = 1;
            tmpi--;
        }
        // 斜上
        tmpi = i;
        tmpj = j;
        while (tmpi - 1 >= 0 && tmpj + 1 < n) {
            map[tmpi - 1][tmpj + 1] = 1;
            tmpi--;
            tmpj++;
        }
        // 右
        tmpi = i;
        tmpj = j;
        while (tmpj + 1 < n) {
            map[tmpi][tmpj + 1] = 1;
            tmpj++;
        }
        // 右下
        tmpi = i;
        tmpj = j;
        while (tmpi + 1 < n && tmpj + 1 < n) {
            map[tmpi + 1][tmpj + 1] = 1;
            tmpi++;
            tmpj++;
        }
        // 下
        tmpi = i;
        tmpj = j;
        while (tmpi + 1 < n) {
            map[tmpi + 1][tmpj] = 1;
            tmpi++;
        }
        // 左下
        tmpi = i;
        tmpj = j;
        while (tmpi + 1 < n && tmpj - 1 >= 0) {
            map[tmpi + 1][tmpj - 1] = 1;
            tmpi++;
            tmpj--;
        }
        // 左
        tmpi = i;
        tmpj = j;
        while (tmpj - 1 >= 0) {
            map[tmpi][tmpj - 1] = 1;
            tmpj--;
        }
        // 左上
        tmpi = i;
        tmpj = j;
        while (tmpi - 1 >= 0 && tmpj - 1 >= 0) {
            map[tmpi - 1][tmpj - 1] = 1;
            tmpi--;
            tmpj--;
        }
        // 当前
        map[i][j] = 1;
    }

    private static int[][] copy(int[][] source) {
        int length = source.length;
        int[][] newArray = new int[length][length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(source[i], 0, newArray[i], 0, length);
        }
        return newArray;
    }

    private static String[][] copy(String[][] source) {
        int length = source.length;
        String[][] newArray = new String[length][length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(source[i], 0, newArray[i], 0, length);
        }
        return newArray;
    }

}
