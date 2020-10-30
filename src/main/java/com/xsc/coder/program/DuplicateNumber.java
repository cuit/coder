package com.xsc.coder.program;

/**
 * @author xia
 * @date 2020/10/29 22:25
 */
public class DuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {6, 2, 3, 4, 1, 3, 5};
        System.out.println(process(nums));
    }

    private static int process(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int i = 0;
        do {
            slow = nums[slow];
            i = nums[i];
        } while (slow != i);
        return slow;
    }
}
