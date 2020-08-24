package com.xsc.coder.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author xia
 * @date 2020/8/3 21:53
 */
public class Test8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int c = scanner.nextInt();
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                if (num == 0) {
                    buildMap(map, i, 0);
                }
                for (int j = 0; j < num; j++) {
                    int color = scanner.nextInt();
                    buildMap(map, i, color);
                }
            }
            int result = process(n, m, c, map);
            System.out.println(result);
        }
    }

    private static int process(int n, int m, int c, Map<Integer, List<Integer>> map) {
        int result = 0;
        for (int i = 1; i <= c; i++) {
            List<Integer> list = map.get(i);
            if (check(n, m, list)) {
                result++;
            }
        }
        return result;
    }

    private static void buildMap(Map<Integer, List<Integer>> map, int i, int color) {
        List<Integer> colorList = map.get(color);
        if (colorList == null) {
            colorList = new ArrayList<>();
            colorList.add(i);
            map.put(color, colorList);
        } else {
            colorList.add(i);
        }
    }

    /**
     * 判断在集合中两个相同颜色的距离是否符合
     *
     * @param m    m
     * @param list 相同颜色出现的位置
     * @return 是否符合
     */
    private static boolean check(int n, int m, List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) < m) {
                return true;
            }
            if (n - (list.get(i) - list.get(i - 1)) < m) {
                return true;
            }
        }
        return false;
    }

}
