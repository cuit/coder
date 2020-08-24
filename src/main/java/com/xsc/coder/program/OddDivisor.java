package com.xsc.coder.program;

import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 小易是一个数论爱好者，并且对于一个数的奇数约数十分感兴趣。一天小易遇到这样一个问题： 定义函数f(x)为x最大的奇数约数，x为正整数。 例如:f(44) = 11.
 * 现在给出一个N，需要求出 f(1) + f(2) + f(3).......f(N)
 * 例如： N = 7
 * f(1) + f(2) + f(3) + f(4) + f(5) + f(6) + f(7) = 1 + 1 + 3 + 1 + 5 + 3 + 7 = 21
 * 小易计算这个问题遇到了困难，需要你来设计一个算法帮助他。
 * 输入描述:
 * 输入一个整数N (1 ≤ N ≤ 1000000000)
 * 输出描述:
 * 输出一个整数，即为f(1) + f(2) + f(3).......f(N)
 * 示例1
 * 输入
 * 7
 * 输出
 * 21
 *
 * @author xia
 * @date 2020/8/24 22:50
 */
public class OddDivisor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            StopWatch stopWatch = new StopWatch();
            int n = scanner.nextInt();
            int x;
            int y;
            if (n % 2 == 0) {
                y = n / 2;
                x = (1 + n - 1) * y / 2;
            } else {
                y = n - (n / 2 + 1);
                x = (1 + n) * (n / 2 + 1) / 2;
            }
            long result = x;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i <= y; i++) {
                if (i % 2 != 0) {
                    result += i;
                    map.put(i, i);
                } else {
                    int j = i / 2;
                    result += map.get(j);
                    map.put(i, map.get(j));
                }
            }
            System.out.println(result);
            stopWatch.stop();
            System.out.println(stopWatch.getLastTaskTimeMillis());
        }
    }

}
