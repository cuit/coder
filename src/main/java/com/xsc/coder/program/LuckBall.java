package com.xsc.coder.program;

import java.util.Scanner;
import java.util.Arrays;

/**
 *题目描述
 * 一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
 * 例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
 * 你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
 * 输入描述:
 * 第一行输入一个正整数n(n ≤ 1000)
 * 第二行为n个数正整数xi(xi ≤ 1000)
 * 输出描述:
 * 输出可以产生的幸运的袋子数
 * 示例1
 * 输入
 * 3
 * 1 1 1
 * 输出
 * 2
 *
 * @author xia
 * @date 2020/8/20 22:07
 */
public class LuckBall {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] balls = new int[n];
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                balls[i] = num;
            }
            Arrays.sort(balls);
            int result = process(balls, 0, 0, 1);
            System.out.println(result);
        }
    }

    private static int process(int[] nums, int index, long sum, long multi) {
        int count = 0;
        for (int i = index; i < nums.length; i++) {
            sum += nums[i];
            multi *= nums[i];
            if (sum > multi) {
                count += 1 + process(nums, i + 1, sum, multi);
            } else if (nums[i] == 1) {
                count += process(nums, i + 1, sum, multi);
            } else {
                break;
            }
            sum -= nums[i];
            multi /= nums[i];
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return count;
    }
}
