package com.xsc.coder.program.y22.m07;

/**
 * 描述
 * 请实现无重复数字的升序数组的二分查找
 * <p>
 * 给定一个 元素升序的、无重复数字的整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标（下标从 0 开始），否则返回 -1
 * <p>
 * 数据范围：0 \le len(nums) \le 2\times10^50≤len(nums)≤2×10
 * 5
 * ， 数组中任意值满足 |val| \le 10^9∣val∣≤10
 * 9
 * <p>
 * 进阶：时间复杂度 O(\log n)O(logn) ，空间复杂度 O(1)O(1)
 * <p>
 * 示例1
 * 输入：
 * [-1,0,3,4,6,10,13,14],13
 * 复制
 * 返回值：
 * 6
 * 复制
 * 说明：
 * 13 出现在nums中并且下标为 6
 * 示例2
 * 输入：
 * [],3
 * 复制
 * 返回值：
 * -1
 * 复制
 * 说明：
 * nums为空，返回-1
 * 示例3
 * 输入：
 * [-1,0,3,4,6,10,13,14],2
 * 复制
 * 返回值：
 * -1
 * 复制
 * 说明：
 * 2 不存在nums中因此返回 -1
 *
 * @author xia
 * @date 2022/6/25 21:23
 */
public class Search {

    public static int search(int[] nums, int target) {
        // write code here
        if (nums.length == 0) {
            return -1;
        }
        return splitSearch(nums, 0, nums.length - 1, target);
    }

    private static int splitSearch(int[] nums, int left, int right, int target) {
        int result = -1;
        if (left == right) {
            if (nums[left] == target) {
                return left;
            }
            return result;
        }
        int mid = (left + right) / 2;
        if (target < nums[mid]) {
            result = splitSearch(nums, left, mid, target);
        } else if (target > nums[mid]) {
            result = splitSearch(nums, mid + 1, right, target);
        } else {
            result = mid;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        int search = search(nums, 1);
        System.out.println(search);
    }
}
