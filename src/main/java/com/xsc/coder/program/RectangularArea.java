package com.xsc.coder.program;

/**
 * 获取数组的最大矩形面积
 *
 * @author xia
 * @date 2020/9/15 22:46
 */
public class RectangularArea {

    public static void main(String[] args) {
        int[] num1 = {1, 3, 2, 4};
        System.out.println(getMaxRectangularArea(num1));
        int[] num2 = {3, 1, 5, 2, 4, 3, 1};
        System.out.println(getMaxRectangularArea(num2));
    }

    private static int getMaxRectangularArea(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < num.length; i++) {
            int currentHeight = num[i];
            int j = i - 1;
            while (j >= 0 && num[j] >= currentHeight) {
                j--;
            }
            int k = i + 1;
            while (k < num.length && num[k] >= currentHeight) {
                k++;
            }
            result = Math.max(result, currentHeight * (k - j - 1));
        }
        return result;  
    }
}
