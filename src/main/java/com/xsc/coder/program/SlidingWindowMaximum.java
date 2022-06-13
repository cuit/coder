//package com.xsc.coder.program;
//
//import java.util.Collections;
//import java.util.List;
//
///**
// * @author xia
// * @date 2020/11/9 22:00
// */
//public class SlidingWindowMaximum {
//
//    private static List<Integer> getSlidingWindowMaximum(int[] numbers, int k) {
//        if (numbers.length == 0) {
//            return Collections.emptyList();
//        }
//        int currentMax = Integer.MIN_VALUE;
//        int currentIndex = 0;
//        for (int i = 0; i < k; i++) {
//            if (numbers[i] >= currentMax) {
//                currentMax = numbers[i];
//                currentIndex = i;
//            }
//        }
//        for (int i = k; i < numbers.length; i++) {
//            if (numbers[i] >= currentMax && i - currentIndex < k) {
//                currentMax = numbers[i];
//                currentIndex = i;
//            } else {
////                for ()
////            }
//        }
//    }
//}
