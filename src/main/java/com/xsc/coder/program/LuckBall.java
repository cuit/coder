package com.xsc.coder.program;

import java.util.Scanner;
import java.util.Arrays;

/**
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
