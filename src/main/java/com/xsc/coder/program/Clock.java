package com.xsc.coder.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 小W有一个电子时钟用于显示时间，显示的格式为HH:MM:SS，HH，MM，SS分别表示时，分，秒。其中时的范围为[‘00’,‘01’…‘23’]，分的范围为[‘00’,‘01’…‘59’]，秒的范围为[‘00’,‘01’…‘59’]。
 *
 * 但是有一天小W发现钟表似乎坏了，显示了一个不可能存在的时间“98:23:00”，小W希望改变最少的数字，使得电子时钟显示的时间为一个真实存在的时间，譬如“98:23:00”通过修改第一个’9’为’1’，即可成为一个真实存在的时间“18:23:00”。修改的方法可能有很多，小W想知道，在满足改变最少的数字的前提下，符合条件的字典序最小的时间是多少。其中字典序比较为用“HHMMSS”的6位字符串进行比较。
 *
 * 输入描述:
 * 每个输入数据包含多个测试点。每个测试点后有一个空行。 第一行为测试点的个数T(T<=100)。 每个测试点包含1行，为一个字符串”HH:MM:SS”，表示钟表显示的时间。
 * 输出描述:
 * 对于每个测试点，输出一行。如果钟表显示的时间为真实存在的时间，则不做改动输出该时间，否则输出一个新的”HH:MM:SS”，表示修改最少的数字情况下，字典序最小的真实存在的时间。
 * 示例1
 * 输入
 * 2
 * 19:90:23
 * 23:59:59
 * 输出
 * 19:00:23
 * 23:59:59
 *
 * @author xia
 * @date 2020/8/30 22:10
 */
public class Clock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int t = scanner.nextInt();
            String[] strings = new String[t];
            for (int i = 0; i < t; i++) {
                strings[i] = scanner.next();
            }
            List<String> results = process(strings);
            results.forEach(System.out::println);
        }
    }

    private static List<String> process(String[] strings) {
        List<String> results = new ArrayList<>();
        for (String string : strings) {
            String[] strs = string.split(":");
            int hh = Integer.parseInt(strs[0]);
            int mm = Integer.parseInt(strs[1]);
            int ss = Integer.parseInt(strs[2]);
            StringBuilder sb = new StringBuilder();
            if (hh > 23) {
                sb.append("0").append(hh % 10).append(":");
            } else {
                if (hh >= 10) {
                    sb.append(hh).append(":");
                } else {
                    sb.append("0").append(hh).append(":");
                }
            }
            if (mm > 59) {
                sb.append("0").append(mm % 10).append(":");
            } else {
                if (mm >= 10) {
                    sb.append(mm).append(":");
                } else {
                    sb.append("0").append(mm).append(":");
                }
            }
            if (ss > 59) {
                sb.append("0").append(ss % 10);
            } else {
                if (ss >= 10) {
                    sb.append(ss);
                } else {
                    sb.append("0").append(ss);
                }
            }
            results.add(sb.toString());
        }
        return results;
    }

}
