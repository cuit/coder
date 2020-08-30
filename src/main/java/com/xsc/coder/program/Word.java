package com.xsc.coder.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 注意：本题允许使用C/C++/Java/python进行解答，其他编程语言提交均视作无效处理。
 * <p>
 * 字符迷阵是一种经典的智力游戏。玩家需要在给定的矩形的字符迷阵中寻找特定的单词。
 * 在这题的规则中，单词是如下规定的：
 * 1. 在字符迷阵中选取一个字符作为单词的开头；
 * 2. 选取右方、下方、或右下45度方向作为单词的延伸方向；
 * 3. 以开头的字符，以选定的延伸方向，把连续得到的若干字符拼接在一起，则称为一个单词。
 * <p>
 * 以图1为例，如果要在其中寻找单词"WORD"，则绿色框所标示的都是合法的方案，而红色框所标示的都是不合法的方案。
 * 现在的问题是，给出一个字符迷阵，及一个要寻找的单词，问能在字符迷阵中找到多少个该单词的合法方案。注意合法方案是可以重叠的，如图1所示的字符迷阵，其中单词"WORD"的合法方案有4种。
 * 输入描述:
 * 输入的第一行为一个正整数T，表示测试数据组数。 接下来有T组数据。每组数据的第一行包括两个整数m和n，表示字符迷阵的行数和列数。接下来有m行，每一行为一个长度为n的字符串，按顺序表示每一行之中的字符。再接下来还有一行包括一个字符串，表示要寻找的单词。  数据范围： 对于所有数据，都满足1<=T<=9，且输入的所有位于字符迷阵和单词中的字符都为大写字母。要寻找的单词最短为2个字符，最长为9个字符。字符迷阵和行列数，最小为1，最多为99。 对于其中50%的数据文件，字符迷阵的行列数更限制为最多为20。
 * 输出描述:
 * 对于每一组数据，输出一行，包含一个整数，为在给定的字符迷阵中找到给定的单词的合法方案数。
 * 示例1
 * 输入
 * 3
 * 10 10
 * AAAAAADROW
 * WORDBBBBBB
 * OCCCWCCCCC
 * RFFFFOFFFF
 * DHHHHHRHHH
 * ZWZVVVVDID
 * ZOZVXXDKIR
 * ZRZVXRXKIO
 * ZDZVOXXKIW
 * ZZZWXXXKIK
 * WORD
 * 3 3
 * AAA
 * AAA
 * AAA
 * AA
 * 5 8
 * WORDSWOR
 * ORDSWORD
 * RDSWORDS
 * DSWORDSW
 * SWORDSWO
 * SWORD
 * 输出
 * 4
 * 16
 * 5
 *
 * @author xia
 * @date 2020/8/30 22:37
 */
public class Word {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int t = scanner.nextInt();
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                int m = scanner.nextInt();
                int n = scanner.nextInt();
                char[][] chars = new char[m][n];
                for (int j = 0; j < m; j++) {
                    char[] charArray = scanner.next().toCharArray();
                    if (n >= 0) System.arraycopy(charArray, 0, chars[j], 0, n);
                }
                String word = scanner.next();
                results.add(process(chars, word));
            }
            results.forEach(System.out::println);
        }
    }

    private static int process(char[][] chars, String word) {
        int result = 0;
        int len = word.length();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                boolean flag = true;
                if (j + len <= chars[0].length) {
                    char[] chars1 = Arrays.copyOfRange(chars[i], j, j + len);
                    if (word.equals(String.valueOf(chars1))) {
                        result++;
                    }
                } else {
                    flag = false;
                }
                if (i + len <= chars.length) {
                    StringBuilder sb = new StringBuilder();
                    int k = 0;
                    while (k < len) {
                        sb.append(chars[i + k][j]);
                        k++;
                    }
                    if (word.equals(sb.toString())) {
                        result++;
                    }
                } else {
                    flag = false;
                }
                if (flag) {
                    StringBuilder sb = new StringBuilder();
                    int k = 0;
                    while (k < len) {
                        sb.append(chars[i + k][j + k]);
                        k++;
                    }
                    if (word.equals(sb.toString())) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
