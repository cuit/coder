package com.xsc.coder.program;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 小明是幼儿园的一名老师。某天幼儿园园长给小朋友们每人发一颗糖果，小朋友们拿到后发现有一些同学拿到的糖果颜色和自己相同，有一些同学糖果颜色和自己不同。
 * 假定每个小朋友只知道有多少同学和自己拿到了相同颜色的糖果。
 * 上课后，有一部分小朋友兴奋的把这一结果告诉小明老师，并让小明老师猜一猜，最少有多少同学拿到了糖果。
 * 例如有三个小朋友告诉小明老师这一结果如下：
 * 其中第一个小朋友发现有1人和自己糖果颜色一样，第二个小朋友也发现有1人和自己糖果颜色一样，第三个小朋友发现有3人和自己糖果颜色一样。
 * 第一二个小朋友可互相认为对方和自己颜色相同，比如红色；
 * 第三个小朋友不可能再为红色（否则第一二个小朋友会发现有2人和自己糖果颜色相同），假设他拿到的为蓝色糖果，那么至少还有另外3位同学拿到蓝色的糖果，最终至少有6位小朋友拿到了糖果。
 * 现在请你帮助小明老师解答下这个谜题。
 * 输入描述:
 * 假定部分小朋友的回答用空格间隔，如 1 1 3
 * 输出描述:
 * 直接打印最少有多少位小朋友拿到糖果
 * 如 6
 * 示例1
 * 输入
 * 1 1 3
 * 输出
 * 6
 * 示例2
 * 输入
 * 0 0 0
 * 输出
 * 3
 * 说明
 * 三位小朋友都没发现有人和自己的颜色相同，所以最少的情况就是三位小朋友糖果的颜色均不同
 *
 * @author xia
 * @date 2020/9/13 19:30
 */
public class Candy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] answers = scanner.nextLine().split(" ");
            Map<Integer, Integer> map = new HashMap<>();
            for (String s : answers) {
                int a = Integer.parseInt(s);
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
            int result = 0;
            for (Integer i : map.keySet()) {
                Integer valueLen = map.get(i);
                int c = valueLen / (i + 1);
                int m = valueLen % (i + 1);
                result += c * (i + 1);
                if (m != 0) {
                    result += i + 1;
                }
            }
            System.out.println(result);
        }
    }
}
