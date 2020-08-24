package com.xsc.coder.program;

import java.util.Random;

/**
 * @author xia
 * @date 2020/8/2 21:47
 */
public class Test6 {

    public static void main(String[] args) {
        int n = 1024;
        for (int i = 0; i < 100; i++) {
            int money = new Random().nextInt(500) + 200;
            money = n - money;
            if (process(money) != process2(money)) {
                System.out.println("111");
            }
        }
    }

    private static int process(int money) {
        int result = 0;
        if (money >= 64) {
            result += money / 64;
            money = money % 64;
        }
        if (money >= 16) {
            result += money / 16;
            money = money % 16;
        }
        if (money >= 4) {
            result += money / 4;
            money = money % 4;
        }
        if (money >= 1) {
            result += money;
        }
        return result;
    }

    private static int process2(int n) {
        int[] money = {1, 4, 16, 64};
        int[] dp = new int[n + 1];
        // 初始化dp数组
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < money.length; j++) {
                if (i - money[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - money[j]] + 1);
                }
            }
        }
        return dp[n];
    }
}
