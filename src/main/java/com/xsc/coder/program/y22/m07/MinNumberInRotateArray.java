package com.xsc.coder.program.y22.m07;

/**
 * 描述
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。请问，给定这样一个旋转数组，求数组中的最小值。
 * <p>
 * 数据范围：1 \le n \le 100001≤n≤10000，数组中任意元素的值: 0 \le val \le 100000≤val≤10000
 * 要求：空间复杂度：O(1)O(1) ，时间复杂度：O(logn)O(logn)
 * 示例1
 * 输入：
 * [3,4,5,1,2]
 * 复制
 * 返回值：
 * 1
 * 复制
 * 示例2
 * 输入：
 * [3,100,200,3]
 * 复制
 * 返回值：
 * 3
 *
 * @author xia
 * @date 2022/7/16 21:57
 */
public class MinNumberInRotateArray {

    public static int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (array[middle] > array[right]) {
                left = middle + 1;
            } else if (array[middle] < array[right]) {
                right = middle;
            } else {
                right = right - 1;
            }
        }
        return array[left];
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 1, 1, 1};
        System.out.println(minNumberInRotateArray(array));
    }
}
