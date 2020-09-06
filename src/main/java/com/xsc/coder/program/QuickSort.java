package com.xsc.coder.program;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author xia
 * @date 2020/9/6 21:01
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {4, 5, 3, 6, 2, 7, 1};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    private static void sort(int[] nums, int start, int end) {
        int base = nums[start];
        int low = start;
        int high = end;
        while (low < high) {
            while (low < high && nums[high] >= base) {
                high--;
            }
            if (nums[high] < base) {
                int temp = nums[high];
                nums[high] = nums[low];
                nums[low] = temp;
            }
            while (low < high && nums[low] <= base) {
                low++;
            }
            if (nums[low] > base) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
            }
        }
        if (start < low) {
            sort(nums, start, low - 1);
        }
        if (end > high) {
            sort(nums, high + 1, end);
        }
    }

}
