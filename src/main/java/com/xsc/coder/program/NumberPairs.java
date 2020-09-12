package com.xsc.coder.program;

import com.google.common.base.Stopwatch;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
            Stopwatch stopwatch = Stopwatch.createStarted();
            System.out.println(process(n, k));
            System.out.println("耗时:" + stopwatch.elapsed(TimeUnit.SECONDS));
        }
    }

    private static long process(int n, int k) {
        // x / y >= k
        if (k == 0) {
            return (long) n * n;
        }
        long result = 0;
        // 如果想满足余数大于或等于k,则被除数必须满足大于k，才有可能
        for (int y = k + 1; y <= n; y++) {
            // 如果n=14, k = 3, 此时y=5
            // 那么 x 就有 3,4, 8,9 满足
            result += (n / y) * (y - k);
            // 剩余部分 为4个数
            int temp = n % y;
            if (temp >= k) {
                // 13 14 满足
                result += temp - k + 1;
            }
        }
        return result;
    }
}
