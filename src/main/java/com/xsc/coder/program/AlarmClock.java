package com.xsc.coder.program;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 牛牛总是睡过头，所以他定了很多闹钟，只有在闹钟响的时候他才会醒过来并且决定起不起床。从他起床算起他需要X分钟到达教室，上课时间为当天的A时B分，请问他最晚可以什么时间起床
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个正整数，表示闹钟的数量N(N<=100)。
 * 接下来的N行每行包含两个整数，表示这个闹钟响起的时间为Hi(0<=A<24)时Mi(0<=B<60)分。
 * 接下来的一行包含一个整数，表示从起床算起他需要X(0<=X<=100)分钟到达教室。
 * 接下来的一行包含两个整数，表示上课时间为A(0<=A<24)时B(0<=B<60)分。
 * 数据保证至少有一个闹钟可以让牛牛及时到达教室。
 * 输出描述:
 * 输出两个整数表示牛牛最晚起床时间。
 * 示例1
 * 输入
 * 3
 * 5 0
 * 6 0
 * 7 0
 * 59
 * 6 59
 * 输出
 * 6 0
 *
 * @author xia
 * @date 2020/9/12 20:10
 */
public class AlarmClock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<Clock> clocks = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                clocks.add(new Clock(h, m));
            }
            int x = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(process(clocks, x, a, b));
        }
    }

    private static String process(List<Clock> clocks, int x, int a, int b) {
        if (x <= b) {
            b -= x;
        } else {
            b += 60 - x;
            a -= 1;
            if (a < 0) {
                a += 24;
            }
        }
        clocks.sort(Comparator.comparing(Clock::getH).reversed()
                .thenComparing(Comparator.comparing(Clock::getM).reversed()));
        for (Clock clock : clocks) {
            if (clock.getH() > a) {
                continue;
            }
            if (clock.getH() == a) {
                if (clock.getM() <= b) {
                    return clock.getH() + " " + clock.getM();
                }
            } else {
                return clock.getH() + " " + clock.getM();
            }
        }
        return null;
    }

    private static class Clock {

        private int h;

        private int m;

        public Clock(int h, int m) {
            this.h = h;
            this.m = m;
        }

        public int getH() {
            return h;
        }

        public int getM() {
            return m;
        }
    }
}
