package com.xsc.coder.program;

import java.util.Scanner;

/**
 * 题目描述
 * 小易非常喜欢拥有以下性质的数列:
 * 1、数列的长度为n
 * 2、数列中的每个数都在1到k之间(包括1和k)
 * 3、对于位置相邻的两个数A和B(A在B前),都满足(A <= B)或(A mod B != 0)(满足其一即可)
 * 例如,当n = 4, k = 7
 * 那么{1,7,7,2},它的长度是4,所有数字也在1到7范围内,并且满足第三条性质,所以小易是喜欢这个数列的
 * 但是小易不喜欢{4,4,4,2}这个数列。小易给出n和k,希望你能帮他求出有多少个是他会喜欢的数列。
 * 输入描述:
 * 输入包括两个整数n和k(1 ≤ n ≤ 10, 1 ≤ k ≤ 10^5)
 * 输出描述:
 * 输出一个整数,即满足要求的数列个数,因为答案可能很大,输出对1,000,000,007取模的结果。
 * 示例1
 * 输入
 * 2 2
 * 输出
 * 3
 *
 * @author xia
 * @date 2020/8/27 21:18
 */
public class Sequence {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int result = process(n, k);
            System.out.println(result);
        }
    }

    private static int process(int n, int k) {
        int result = 0;
        // dp[i][j]:表示数列的长度为i时，以j为结尾的有效队列个数
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= k; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            // sum:表示数列长度为i时，总的队列个数
            int sum = 0;
            for (int j = 1; j <= k; j++) {
                sum = (sum + dp[i - 1][j]) % MOD;
            }
            for (int j = 1; j <= k; j++) {
                int invalid = 0;
                int p = 2;
                while (p * j <= k) {
                    invalid = (invalid + dp[i - 1][p * j]) % MOD;
                    p++;
                }
                dp[i][j] = (sum - invalid + MOD) % MOD;
            }
        }
        for (int i = 1; i <= k; i++) {
            result = (result + dp[n][i]) % MOD;
        }
        return result;
    }
}
