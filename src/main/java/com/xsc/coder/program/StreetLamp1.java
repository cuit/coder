package com.xsc.coder.program;

import java.util.Scanner;

/**
 * 题目描述
 * 小Q正在给一条长度为n的道路设计路灯安置方案。
 * <p>
 * 为了让问题更简单,小Q把道路视为n个方格,需要照亮的地方用'.'表示, 不需要照亮的障碍物格子用'X'表示。
 * <p>
 * 小Q现在要在道路上设置一些路灯, 对于安置在pos位置的路灯, 这盏路灯可以照亮pos - 1, pos, pos + 1这三个位置。
 * <p>
 * 小Q希望能安置尽量少的路灯照亮所有'.'区域, 希望你能帮他计算一下最少需要多少盏路灯。
 * <p>
 * 输入描述:
 * 输入的第一行包含一个正整数t(1 <= t <= 1000), 表示测试用例数
 * 接下来每两行一个测试数据, 第一行一个正整数n(1 <= n <= 1000),表示道路的长度。
 * 第二行一个字符串s表示道路的构造,只包含'.'和'X'。
 * 输出描述:
 * 对于每个测试用例, 输出一个正整数表示最少需要多少盏路灯。
 * 示例1
 * 输入
 * 2
 * 3
 * .X.
 * 11
 * ...XX....XX
 * 输出
 * 1
 * 3
 *
 * @author xia
 * @date 2020/9/9 21:29
 */
public class StreetLamp1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int t = scanner.nextInt();
            for (int i = 0; i < t; i++) {
                int n = scanner.nextInt();
                String str = scanner.next();
                System.out.println(process(str));
                System.out.println(process1(str));
            }
        }
    }

    /**
     * 方法一
     */
    private static int process(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int result = 0;
        char[] chars = str.toCharArray();
        boolean[] flags = new boolean[str.length()];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'X' || flags[i]) {
                continue;
            }
            flags[i] = true;
            if (i + 2 < chars.length) {
                flags[i + 1] = true;
                flags[i + 2] = true;
            } else if (i + 1 < chars.length) {
                flags[i + 1] = true;
            }
            result++;
        }
        return result;
    }

    /**
     * 方法二：每次如果匹配上了'.'，自动往后跳跃三位
     */
    private static int process1(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'X') {
                continue;
            }
            i += 2;
            result++;
        }
        return result;
    }
}
