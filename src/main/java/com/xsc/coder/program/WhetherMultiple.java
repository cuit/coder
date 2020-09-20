package com.xsc.coder.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/f970201e9f7e4040ab25a40918e27d15
 * 来源：牛客网
 * <p>
 * 牛牛有一个正整数x,牛牛需要把数字x中的数位进行重排得到一个新数(不同于x的数),牛牛想知道这个新数是否可能是原x的倍数。请你来帮他解决这个问题。
 * <p>
 * 输入描述:
 * 输入包括t+1行,第一行包括一个整数t(1 ≤ t ≤ 10),
 * 接下来t行,每行一个整数x(1 ≤ x ≤ 10^6)
 * <p>
 * <p>
 * 输出描述:
 * 对于每个x,如果可能重排之后变为自己的倍数输出"Possible", 否则输出"Impossible".
 * 示例1
 * 输入
 * 2
 * 14
 * 1035
 * 输出
 * Impossible
 * Possible
 *
 * @author xia
 * @date 2020/9/17 22:41
 */
public class WhetherMultiple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int t = scanner.nextInt();
            String[] strings = new String[t];
            for (int i = 0; i < t; i++) {
                strings[i] = scanner.next();
            }
            for (String string : strings) {
                if (isMultiple(string)) {
                    System.out.println("Possible");
                } else {
                    System.out.println("Impossible");
                }
            }
        }
    }

    private static boolean isMultiple(String str) {
        list = new ArrayList<>();
        char[] chars = str.toCharArray();
        q(chars, 0, chars.length - 1);
        for (char[] chars1 : list) {
            String s = String.valueOf(chars1);
            if (s.equals(str)) {
                continue;
            }
            if (Integer.parseInt(s) % Integer.parseInt(str) == 0) {
                return true;
            }
        }
        return false;
    }

    private static List<char[]> list;

    private static void q(char[] chars, int start, int end) {
        if (start == end) {
            char[] newChar = Arrays.copyOf(chars, chars.length);
            list.add(newChar);
        } else {
            for (int i = start; i <= end; i++) {
                char tmp = chars[start];
                chars[start] = chars[i];
                chars[i] = tmp;
                q(chars, start + 1, end);
                tmp = chars[start];
                chars[start] = chars[i];
                chars[i] = tmp;
            }
        }
    }
}
