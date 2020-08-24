package com.xsc.coder.program;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author xia
 * @date 2020/7/30 11:14
 */
public class Test3 {

    private static final int NUM_2 = 2;

    private static final int NUM_3 = 3;

    private static final int NUM_4 = 4;

    private static final int NUM_9 = 9;

    private static final int NUM_10 = 10;

    private static final int NUM_12 = 12;

    private static final int NUM_13 = 13;

    private static final int NUM_14 = 14;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < NUM_13; i++) {
            nums.add(scanner.nextInt());
        }
        List<Integer> process = process(nums);
        if (process.size() == 0) {
            System.out.println(0);
        } else {
            Collections.sort(process);
            System.out.println(process.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }

    private static List<Integer> process(List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= NUM_10 - 1; i++) {
            if (isCanAdd(nums, i)) {
                list.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Integer integer : list) {
            List<Integer> ll = new ArrayList<>(nums);
            ll.add(integer);
            Collections.sort(ll);
            if (isMatch(ll)) {
                result.add(integer);
            }
        }
        return result;
    }

    private static boolean isCanAdd(List<Integer> list, int key) {
        int left = 0;
        if (key > 1) {
            left = key - 1;
        }
        int right = NUM_10;
        if (key < NUM_9) {
            right = key + 1;
        }
        boolean flagL = false, flagR = false;
        int count = 0;
        for (Integer integer : list) {
            if (integer == key) {
                count++;
            } else {
                if (integer == left) {
                    flagL = true;
                }
                if (integer == right) {
                    flagR = true;
                }
            }
        }
        if (count == 0 && (flagL || flagR)) {
            return true;
        }
        return count < NUM_4;
    }

    private static boolean isMatch(List<Integer> nums) {
        // 选出可以作为雀头
        List<Integer> candidate = new ArrayList<>();
        for (int i = 1; i < NUM_14; i++) {
            if (nums.get(i).equals(nums.get(i - 1)) && !candidate.contains(nums.get(i))) {
                candidate.add(nums.get(i));
            }
        }
        LinkedList<Integer> list;
        for (int que : candidate) {
            list = new LinkedList<>();
            boolean f = false;
            for (int j = 0; j < NUM_12; j++) {
                if (f) {
                    list.add(nums.get(j + NUM_2));
                } else {
                    if (nums.get(j) == que) {
                        f = true;
                        list.add(nums.get(j + NUM_2));
                    } else {
                        list.add(nums.get(j));
                    }
                }
            }
            boolean flag = false;
            // 判断是否是4个刻子
            for (int j = 0; j < NUM_10; j = j + NUM_3) {
                if (!list.get(j).equals(list.get(j + 1)) || !list.get(j + 1).equals(list.get(j + NUM_2))) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return true;
            }
            flag = false;
            // 判断是否是4个顺子
            for (int j = 0; j < NUM_4; j++) {
                Integer integer = list.pollFirst();
                if (integer == null) {
                    break;
                }
                if (list.contains(integer + 1) && list.contains(integer + 2)) {
                    list.remove((Integer) (integer + 1));
                    list.remove((Integer) (integer + NUM_2));
                } else {
                    flag = true;
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                return true;
            }
        }
        return false;
    }
}
