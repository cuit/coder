package com.xsc.coder.program;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/83b419c027fa490aa60669b0e7dc06a3
 * 来源：牛客网
 * <p>
 * 又到了丰收的季节，恰逢小易去牛牛的果园里游玩。
 * 牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。
 * 在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆的。
 * 牛牛觉得这个问题太简单，所以希望你来替他回答。
 * <p>
 * 输入描述:
 * 第一行一个数n(1 <= n <= 105)。
 * 第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
 * 第三行一个数m(1 <= m <= 105)，表示有m次询问。
 * 第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
 * <p>
 * <p>
 * 输出描述:
 * m行，第i行输出第qi个苹果属于哪一堆。
 * 示例1
 * 输入
 * 5
 * 2 7 3 4 9
 * 3
 * 1 25 11
 * 输出
 * 1
 * 5
 * 3
 *
 * @author xia
 * @date 2020/9/24 21:55
 */
public class Harvest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Map<Integer, Integer> map = new LinkedHashMap<>();
            int tmp;
            for (int i = 0; i < n; i++) {
                tmp = scanner.nextInt();
                map.put(i, map.getOrDefault(i - 1, 0) + tmp);
            }
            int m = scanner.nextInt();
            Label[] labels = new Label[m];
            for (int i = 0; i < m; i++) {
                tmp = scanner.nextInt();
                labels[i] = new Label(i, tmp);
            }
            int j = 0;
            Arrays.sort(labels, Comparator.comparing(Label::getValue));
            for (int i = 0; i < m; i++) {
                for (; j < map.size(); j++) {
                    if (map.get(j) >= labels[i].value) {
                        labels[i].pos = j + 1;
                        break;
                    }
                }
            }
            Arrays.sort(labels, Comparator.comparing(Label::getIndex));
            for (Label label : labels) {
                System.out.println(label.pos);
            }
        }
    }

    private static class Label {

        private int index;

        private int value;

        private int pos;

        public Label(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }
}
