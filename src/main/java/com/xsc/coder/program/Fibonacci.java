package com.xsc.coder.program;

import com.google.common.base.Stopwatch;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author xia
 * @date 2020/9/8 17:28
 */
public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Stopwatch stopwatch1 = Stopwatch.createStarted();
            System.out.println(cacl1(n) + "耗时:" + stopwatch1.elapsed(TimeUnit.MILLISECONDS));
            Stopwatch stopwatch2 = Stopwatch.createStarted();
            System.out.println(cacl2(n) + "耗时:" + stopwatch2.elapsed(TimeUnit.MILLISECONDS));
            Stopwatch stopwatch3 = Stopwatch.createStarted();
            System.out.println(cacl3(n) + "耗时:" + stopwatch3.elapsed(TimeUnit.MILLISECONDS));
        }
    }

    private static long cacl1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return cacl1(n - 1) + cacl1(n - 2);
    }

    private static long cacl2(int n) {
        long[] nums = new long[n];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n - 1];
    }

    private static long cacl3(int n) {
        long i = 1;
        long j = 1;
        for (int k = 2; k < n; k++) {
            long temp = i + j;
            i = j;
            j = temp;
        }
        return j;
    }

}
