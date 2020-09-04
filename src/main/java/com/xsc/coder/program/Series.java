package com.xsc.coder.program;

import java.util.Scanner;

/**
 * 题目描述
 * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
 * <p>
 * 并且小Q对于能否被3整除这个性质很感兴趣。
 * <p>
 * 小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
 * <p>
 * 输入描述:
 * 输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。
 * 输出描述:
 * 输出一个整数, 表示区间内能被3整除的数字个数。
 * 示例1
 * 输入
 * 2 5
 * 输出
 * 3
 *
 * @author xia
 * @date 2020/8/31 22:29
 */
public class Series {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int result = 0;
            for (int i = l; i <= r; i++) {
                if (getNum(i) % 3 == 0) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }

    private static int getNum(int k) {
        StringBuilder sb = new StringBuilder();
        while (k > 0) {
            sb.insert(0, k);
            k--;
        }
        return Integer.parseInt(sb.toString());
    }
}
