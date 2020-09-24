package com.xsc.coder.program;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 题目描述
 * 小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容挺感兴趣，所以希望你在老师讲到有趣的部分的时候叫醒他一下。你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次，这会使得他在接下来的k分钟内保持清醒。你需要选择一种方案最大化小易这堂课听到的知识点分值。
 * 输入描述:
 * 第一行 n, k (1 <= n, k <= 105) ，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
 * 第二行 n 个数，a1, a2, ... , an(1 <= ai <= 104) 表示小易对每分钟知识点的感兴趣评分。
 * 第三行 n 个数，t1, t2, ... , tn 表示每分钟小易是否清醒, 1表示清醒。
 * 输出描述:
 * 小易这堂课听到的知识点的最大兴趣值。
 * 示例1
 * 输入
 * 复制
 * 6 3
 * 1 3 5 2 5 4
 * 1 1 0 1 0 0
 * 输出
 * 复制
 * 16
 *
 * @author xia
 * @date 2020/9/23 22:08
 */
public class Listening {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            Index[] interest = new Index[n];
            for (int i = 0; i < n; i++) {
                interest[i] = new Index(i, scanner.nextInt());
            }
            boolean[] wake = new boolean[n];
            for (int i = 0; i < n; i++) {
                int tmp = scanner.nextInt();
                wake[i] = tmp == 1;
            }
            System.out.println(process(n, k, interest, wake));
        }
    }

    private static int process(int n, int k, Index[] interest, boolean[] weak) {
        int result = 0;
        int tmp = 0;
        Queue<Index> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (weak[i]) {
                result += interest[i].value;
                continue;
            }
            // 需要移除的
            while (!queue.isEmpty() && queue.peek().i + k <= i) {
                tmp -= queue.poll().value;
            }
            if (queue.size() < k) {
                Index current = interest[i];
                tmp += current.value;
                current.result = tmp;
                queue.add(current);
            }
        }
        tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp = Math.max(tmp, interest[i].result);
        }
        return result + tmp;
    }

    private static class Index {

        private int i;

        private int value;

        private int result;

        public Index(int i, int value) {
            this.i = i;
            this.value = value;
        }

        public int getResult() {
            return result;
        }
    }

}
