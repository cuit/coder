package com.xsc.coder.program;

import java.util.Scanner;

/**
 * 题目描述
 * 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
 * <p>
 * 但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
 * 牛牛希望你能帮他计算一共有多少个可能的数对。
 * <p>
 * 输入描述:
 * 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
 * 输出描述:
 * 对于每个测试用例, 输出一个正整数表示可能的数对数量。
 * 示例1
 * 输入
 * 5 2
 * 输出
 * 7
 * 说明
 * 满足条件的数对有(2,3),(2,4),(2,5),(3,4),(3,5),(4,5),(5,3)
 *
 * @author xia
 * @date 2020/9/9 23:05
 */
public class NumberPairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(process(n, k));
        }
    }

    private static int process(int n, int k) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (i >= k) {
                result += n - i;
            }
            for (int j = i / 2; j <= i - k; j++) {
                if (i % j >= k) {
                    result++;
                }
            }
        }
        return result;
    }
}
