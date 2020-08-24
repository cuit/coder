package com.xsc.coder.program;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xia
 * @date 2020/8/16 20:16
 */
public class Color {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] colors = new int[n];
            for (int i = 0; i < n; i++) {
                int color = scanner.nextInt();
                colors[i] = color;
            }
            Arrays.sort(colors);
            for (int i = n - 1; i > 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    if ((colors[j] ^ colors[i]) < colors[j]) {
                        colors[j] ^= colors[i];
                    }
                }
                Arrays.sort(colors);
            }
            int result = 0;
            for (int color : colors) {
                if (color != 0) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }

}
