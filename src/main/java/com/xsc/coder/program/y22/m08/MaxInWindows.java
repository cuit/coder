package com.xsc.coder.program.y22.m08;

import java.util.ArrayList;

/**
 * 描述
 * 给定一个长度为 n 的数组 nums 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
 * <p>
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * <p>
 * 数据范围： 1 \le size \le n \le 100001≤size≤n≤10000，数组中每个元素的值满足 |val| \le 10000∣val∣≤10000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * <p>
 * <p>
 * 示例1
 * 输入：
 * [2,3,4,2,6,2,5,1],3
 * 复制
 * 返回值：
 * [4,4,6,6,6,5]
 * 复制
 * 示例2
 * 输入：
 * [9,10,9,-7,-3,8,2,-6],5
 * 复制
 * 返回值：
 * [10,10,9,8]
 * 复制
 * 示例3
 * 输入：
 * [1,2,3,4],3
 * 复制
 * 返回值：
 * [3,4]
 *
 * @author xia
 * @date 2022/8/30 23:27
 */
public class MaxInWindows {

    public static void main(String[] args) {
        int[] nums = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(nums, 3).toString());
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        // 初始化一个比较的数组
        int[] newNums = new int[size];
        for (int i = 0; i <= num.length - size; i++) {
            if (i == 0) {
                System.arraycopy(num, i, newNums, 0, size);
                heap(newNums);
            } else {
                int delIndex = getIndex(newNums, num[i - 1]);
                int deleteVal = newNums[delIndex];
                int newVal = num[i + size - 1];
                if (newVal <= deleteVal) {

                } else if (newVal > deleteVal && newVal <= )
                newNums[delIndex] = num[i + size - 1];

            }
            if (newNums.length > 0) {
                result.add(newNums[0]);
            }
        }
        return result;
    }

    private static int getIndex(int[] nums, int v) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == v) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 把数组转换成大顶推
     *
     * @param nums 原始数组
     */
    private static void heap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            sort(nums, i);
        }
    }

    /**
     * 把数组i号位置上的值和左右节点上的值进行比较，如果左右节点上的值比它大，则交换，并递归进行
     *
     * @param nums 数组
     * @param i    i好位置
     */
    private static void sort(int[] nums, int i) {
        int index = i;
        int len = nums.length;
        if (2 * i + 1 < len && nums[2 * i + 1] > nums[index]) {
            index = 2 * i + 1;
        }
        if (2 * i + 2 < len && nums[2 * i + 2] > nums[index]) {
            index = 2 * i + 2;
        }
        if (index != i) {
            swap(nums, i, index);
            sort(nums, index);
        }
    }

    /**
     * 数组值交换
     *
     * @param nums 原始数组
     * @param i    第i位置上的值
     * @param j    第j位置上的值
     */
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
