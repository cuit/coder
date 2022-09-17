package com.xsc.coder.program.y22.m09;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 描述
 * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
 * 数据范围：0\le k,n \le 100000≤k,n≤10000，数组中每个数的大小0 \le val \le 10000≤val≤1000
 * 要求：空间复杂度 O(n)O(n) ，时间复杂度 O(nlogn)O(nlogn)
 * <p>
 * 示例1
 * 输入：
 * [4,5,1,6,2,7,3,8],4
 * 复制
 * 返回值：
 * [1,2,3,4]
 * 复制
 * 说明：
 * 返回最小的4个数即可，返回[1,3,2,4]也可以
 * 示例2
 * 输入：
 * [1],0
 * 复制
 * 返回值：
 * []
 * 复制
 * 示例3
 * 输入：
 * [0,1,2,1,2],3
 * 复制
 * 返回值：
 * [0,1,1]
 *
 * @author xia
 * @date 2022/9/17 23:42
 */
public class GetLeastNumbersSolution {

    public static void main(String[] args) {
        int[] nums = {4, 6, 3, 5, 2, 1};
        heap(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static ArrayList<Integer> getLeastNumbersSolution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k <= 0) {
            return result;
        }
        int[] minNums = new int[k];
        if (k >= input.length) {
            for (int i = 0; i < input.length; i++) {
                result.add(input[i]);
            }
            return result;
        }
        System.arraycopy(input, 0, minNums, 0, k);
        for (int i = k; i < input.length; i++) {
            if (input[i] >= minNums[k - 1]) {
                continue;
            }

        }
        return null;
    }

    private static void heap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            sort(nums, i);
        }
    }

    private static void sort(int[] nums, int i) {
        int index = i;
        if (2 * i + 1 < nums.length && nums[index] > nums[2 * i + 1]) {
            index = 2 * i + 1;
        }
        if (2 * i + 2 < nums.length && nums[index] > nums[2 * i + 2]) {
            index = 2 * i + 2;
        }
        if (i != index) {
            swap(nums, i, index);
            sort(nums, index);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
