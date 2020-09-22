package com.xsc.coder.program;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/ff0e55dcb75b45b09164c56f87cdf737
 * 来源：牛客网
 * <p>
 * 牛牛非常喜欢和朋友们一起玩。
 * 牛牛有n个朋友当前在一根数轴上,每个朋友当前在整数x[i]坐标位置。
 * 牛牛向他们发出一个移动的信号,每个朋友就向左或者向右移动s距离(每个朋友的选择是独立的,都可以选择向左或者向右)。
 * 为了在一起玩耍方便,牛牛希望移动之后最左边的朋友和最右边的朋友距离最近,牛牛想知道最近距离为多少。
 * <p>
 * 例如牛牛有三个朋友分别所在数轴坐标为-7, 4, 7, s = 5
 * 那么第一个朋友-7向右移动s,变为-2
 * 第二个朋友4向左移动s,变为-1
 * 第三个朋友7向左移动s,变为2。
 * 现在最左和最右的朋友距离是4,没有比这个更优的方案了。
 * <p>
 * 输入描述:
 * 输入包括两行,第一行两个正整数n和s(2 ≤ n ≤ 50, 0 ≤ s ≤ 10^8),表示朋友的个数和移动的距离。
 * 第二行包括n个正整数x[i](-10^8 ≤ x[i] ≤ 10^8),表示初始时每个朋友所在的坐标位置。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个正整数,表示移动之后最左边的朋友和最右边的朋友最小距离为多少。
 * 示例1
 * 输入
 * 3 5
 * 4 -7 7
 * 输出
 * 4
 *
 * @author xia
 * @date 2020/9/20 19:56
 */
public class Play {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int[] position = new int[n];
            for (int i = 0; i < n; i++) {
                position[i] = scanner.nextInt();
            }
            System.out.println(process(position, s));
        }
    }

    /**
     * 举例：
     * 排好序后 1 3 4 5 6 s:1
     * 此时假设以cur=3为中轴，大于3的4,5,6都向左移动一位，小或等于3的1,3都向右移动1位
     * 此时原右边移动到左边的为3(4-1),4(5-1),5(6-1),此时原左边移动到右边的为2(1+1),4(3+1)
     * 此时排序为2,3,4,4,5
     * 右边界：max(5, 4) = max(原最大值-s, cur+s)
     * 左边界：min(3, 2) = min(curNext-s, 原最小值+s)
     * 每次求（右边界-左边界）的最小值
     */
    private static int process(int[] position, int s) {
        Arrays.sort(position);
        int result = Integer.MAX_VALUE;
        int len = position.length;
        for (int i = 0; i < len - 1; i++) {
            int right = Math.max(position[len - 1] - s, position[i] + s);
            int left = Math.min(position[i + 1] - s, position[0] + s);
            result = Math.min(result, right - left);
        }
        return result;
    }
}
