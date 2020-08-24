package com.xsc.coder.program;

import java.util.Scanner;

/**
 * @author xia
 * @date 2020/8/12 22:15
 */
public class Monster {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int power = scanner.nextInt();
            int[] monsters = new int[n];
            for (int i = 0; i < n; i++) {
                monsters[i] = scanner.nextInt();
            }
            int result = process(monsters, power);
            System.out.println(result);
        }
    }

    private static int process(int[] monsters, int power) {
        int result = power;
        for (int monster : monsters) {
            if (result >= monster) {
                result += monster;
            } else {
                result += getHCF(result, monster);
            }
        }
        return result;

    }

    private static int getHCF(int x, int y) {
        while (x % y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return y;
    }

}
