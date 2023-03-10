package com.xsc.coder.program.y23.m03;

/**
 * @author xia
 * @date 2023/3/10 23:28
 */
public class QuickSort {

    private static void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void sort(int[] nums, int low, int hight) {
        if (low < hight) {
            int key = nums[low];
            int i = low;
            int j = hight;
            while (i < j) {
                while (i < j && nums[j] >= key) {
                    j--;
                }
                if (i < j) {
                    nums[i] = nums[j];
                    nums[j] = key;
                    i++;
                }
                while (i < j && nums[i] < key) {
                    i++;
                }
                if (i < j) {
                    int tmp = nums[i];
                    nums[i] = key;
                    nums[j] = tmp;
                }
            }
            sort(nums, low, i);
            sort(nums, i + 1, hight);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 1, 4};
        quickSort(nums);
    }

}
