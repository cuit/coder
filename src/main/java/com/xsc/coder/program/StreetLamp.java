package com.xsc.coder.program;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author xia
 * @date 2020/8/12 21:13
 */
public class StreetLamp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int l = scanner.nextInt();
            TreeSet<Integer> pos = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                pos.add(scanner.nextInt());
            }
            double result = process(pos, l);
            System.out.println(String.format("%.2f", result));
        }
    }

    private static double process(TreeSet<Integer> pos, int l) {
        double maxLen = pos.first();
        Iterator<Integer> iterator = pos.iterator();
        // 开头
        int before = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            maxLen = Math.max(maxLen, (next - before) / 2D);
            before = next;
        }
        // 结尾
        maxLen = Math.max(maxLen, l - pos.last());
        return maxLen;
    }

}
