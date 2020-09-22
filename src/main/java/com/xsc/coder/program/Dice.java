package com.xsc.coder.program;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/0e83797c34e54cca91179fe9ad681bc4
 * 来源：牛客网
 * <p>
 * 小易参加了一个骰子游戏,这个游戏需要同时投掷n个骰子,每个骰子都是一个印有数字1~6的均匀正方体。
 * 小易同时投掷出这n个骰子,如果这n个骰子向上面的数字之和大于等于x,小易就会获得游戏奖励。
 * 小易想让你帮他算算他获得奖励的概率有多大。
 * <p>
 * 输入描述:
 * 输入包括两个正整数n和x(1 ≤ n < 25, 1 ≤ x < 150),分别表示骰子的个数和可以获得奖励的最小数字和。
 * <p>
 * <p>
 * 输出描述:
 * 输出小易可以获得奖励的概率。
 * 如果概率为1,输出1,如果概率为0,输出0,其他以最简分数(x/y)的形式输出。
 * 示例1
 * 输入
 * 3 9
 * 输出
 * 20/27
 *
 * @author xia
 * @date 2020/9/22 22:34
 */
public class Dice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            System.out.println(process(n, x));
        }
    }

    private static String process(int n, int x) {
        String result;
        if (n * 6 < x) {
            result = "0";
        } else if (n >= x) {
            result = "1";
        } else {
            // dp[x][y]:x个骰子，分数为y的方案种数
            long[][] dp = new long[n + 1][x + 1];
            for (int i = 1; i <= 6; i++) {
                dp[1][i] = 1;
            }
            // n个骰子
            for (int i = 1; i <= n; i++) {
                // 分数从1到x
                for (int j = 1; j <= x; j++) {
                    // 骰子从1到6
                    for (int k = 1; k <= 6; k++) {
                        // 如果当前骰子分数已经超过了X，直接跳过内循环
                        if (j - k < 0) {
                            break;
                        }
                        //投了i个骰子，总得分为j的方案数=投了i-1个骰子，得分为j-1,j-2,...,j-k
                        //（当然前提要j-k>=0,因为不可能投了i-1个骰子得了负分）
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
            // 将得分小于x的求和
            long sum = 0L;
            for (int i = 1; i < x; i++) {
                sum += dp[n][i];
            }
            // 总数
            long total = (long) Math.pow(6, n);
            // 满足条件的
            sum = total - sum;
            long gcd = gcd(total, sum);
            result = sum / gcd + "/" + total / gcd;
        }
        return result;
    }

    private static long gcd(long x, long y) {
        while (x % y != 0) {
            long tmp = x % y;
            x = y;
            y = tmp;
        }
        return y;
    }
}
