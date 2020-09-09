package com.xsc.coder.program;

import java.util.Scanner;

/**
 * 题目描述
 * 牛牛去犇犇老师家补课，出门的时候面向北方，但是现在他迷路了。虽然他手里有一张地图，但是他需要知道自己面向哪个方向，请你帮帮他。
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个正整数，表示转方向的次数N(N<=1000)。
 * 接下来的一行包含一个长度为N的字符串，由L和R组成，L表示向左转，R表示向右转。
 * 输出描述:
 * 输出牛牛最后面向的方向，N表示北，S表示南，E表示东，W表示西。
 * 示例1
 * 输入
 * 3
 * LRR
 * 输出
 * E
 *
 * @author xia
 * @date 2020/9/9 22:32
 */
public class Direction {

    private static final String[] DIRECTION = {"N", "E", "S", "W"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String str = scanner.next();
            System.out.println(process(str));
        }
    }

    /**
     * 或者可以使用：
     * 往右加一，往左减一
     * 如果结果为负加上4即可
     */
    private static String process(String str) {
        // 左右抵消
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            boolean flag = false;
            for (int j = 0; j < sb.length(); j++) {
                if (str.charAt(i) == 'L' && sb.charAt(j) == 'R') {
                    sb.deleteCharAt(j);
                    flag = true;
                    break;
                }
                if (str.charAt(i) == 'R' && sb.charAt(j) == 'L') {
                    sb.deleteCharAt(j);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                sb.append(str.charAt(i));
            }
        }
        int len = sb.length();
        if (len == 0) {
            return DIRECTION[0];
        }
        char c = sb.charAt(0);
        if (c == 'R') {
            return DIRECTION[len % 4];
        } else {
            return DIRECTION[4 - len % 4];
        }
    }
}
