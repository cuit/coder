package com.xsc.coder.program;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * @author xia
 * @date 2020/7/27 22:41
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = scanner.nextInt();
        }
        process(pos, n, d);
    }

    private static void process(int[] pos, int n, int d) {
        int result = 0;
        if (n < 3) {
            System.out.println(result);
        } else {
            for (int i = 2; i < n; i++) {
                int j = 0;
                while (pos[i] - pos[j] > d) {
                    j++;
                }
                result += (i - j) * (i- j - 1) / 2;
            }
            System.out.println(result % 99997867);
        }
    }

}
