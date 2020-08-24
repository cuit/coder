package com.xsc.coder.program;

import java.util.Scanner;

/**
 * @author xia
 * @date 2020/8/14 22:14
 */
public class Choir {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] powers = new int[n];
            for (int i = 0; i < n; i++) {
                powers[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();
            int d = scanner.nextInt();
            long result = process(powers, n, k, d);
            System.out.println(result);
        }
    }

    private static long process(int[] powers, int n, int k, int d) {
        long result = 0;
        // 选k个人中，结尾下标是n的最小值
        long[][] min = new long[k][n];
        // 选k个人中，结尾下标是n的最大值
        long[][] max = new long[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                min[i][j] = 1;
                max[i][j] = 1;
                if (i == 0) {
                    min[i][j] = powers[j];
                    max[i][j] = powers[j];
                }
            }
        }
        for (int i = 1; i < k; i++) {
            for (int j = 1; j < n; j++) {
                for (int m = 1; m <= d; m++) {
                    if (j - m >= 0) {
                        if (powers[j] > 0) {
                            min[i][j] = Math.min(min[i][j], min[i - 1][j - m] * powers[j]);
                            max[i][j] = Math.max(max[i][j], max[i - 1][j - m] * powers[j]);
                        } else {
                            min[i][j] = Math.min(min[i][j], max[i - 1][j - m] * powers[j]);
                            max[i][j] = Math.max(max[i][j], min[i - 1][j - m] * powers[j]);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i >= k - 1) {
                result = Math.max(result, max[k - 1][i]);
            }
        }
        return result;
    }

}
