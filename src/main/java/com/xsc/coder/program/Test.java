package com.xsc.coder.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author xia
 * @date 2020/7/20 22:41
 */
public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputs.add(scanner.next());
        }
        for (String s : inputs) {
            process(s);
        }
    }

    private static void process(String str) {
        if (str.isEmpty() || str.length() < 3) {
            System.out.println(str);
        }
        String result = process2(process3(str));
        System.out.println(result);
    }

    private static String process3(String str) {
        if (str.length() < 3) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i + 2 < str.length() && str.charAt(i) == str.charAt(i + 1) && str.charAt(i) == str.charAt(i + 2)) {
                // 去掉相同三个字符中最后一个字符
                stringBuilder.append(str.substring(i, i + 2));
                // 如果连续相同的三个字符后面还有和当前字符一样的连续的情况下，需要都删除
                int j = i + 3;
                while (j < str.length() && str.charAt(i) == str.charAt(j)) {
                    j++;
                }
                i = j - 1;
                continue;
            }
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    private static String process2(String str) {
        if (str.length() < 4) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i + 3 < str.length() && str.charAt(i) == str.charAt(i + 1) && str.charAt(i + 2) == str.charAt(i + 3)) {
                // 去掉连续两队相同中第二队的最后一个字符
                stringBuilder.append(str.substring(i, i + 3));
                i += 3;
                continue;
            }
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

}
