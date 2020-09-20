package com.xsc.coder.program;

import java.util.Arrays;

/**
 * 迪杰斯特拉 求图最短路径
 *
 * @author xia
 * @date 2020/9/20 12:55
 */
public class Dijkstra {

    public static void main(String[] args) {
        // 按 北京 天津 郑州 长沙 济南 海南
        int[][] distance = {
                {0, 100, 1200, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {100, 0, 900, Integer.MAX_VALUE, 300, Integer.MAX_VALUE},
                {1200, 900, 0, 500, 400, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 500, 0, 1300, 1500},
                {Integer.MAX_VALUE, 300, 400, 1300, 0, 1400},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1500, 1400, 0}
        };
        int[] minDis = process(distance, 0);
        System.out.println(Arrays.toString(minDis));
        minDis = process(distance, 1);
        System.out.println(Arrays.toString(minDis));
        minDis = process(distance, 2);
        System.out.println(Arrays.toString(minDis));
        minDis = process(distance, 3);
        System.out.println(Arrays.toString(minDis));
    }

    private static int[] process(int[][] distance, int start) {
        // 一共几个地点
        int length = distance.length;
        // 代表这些地点是否已经访问，已经确认了最短路径
        boolean[] visit = new boolean[length];
        visit[start] = true;
        // 存储距离start的最短路径
        int[] minDis = new int[length];
        // 初始化minDis数组
        System.arraycopy(distance[start], 0, minDis, 0, length);
        for (int i = 0; i < length; i++) {
            // 找出未被访问的最短路径
            int minD = Integer.MAX_VALUE;
            // 找出未被访问的最短路径的下标
            int index = 0;
            for (int j = 0; j < length; j++) {
                if (!visit[j] && minD > minDis[j]) {
                    minD = minDis[j];
                    index = j;
                }
            }
            for (int j = 0; j < length; j++) {
                if (visit[j] || distance[index][j] == Integer.MAX_VALUE) {
                    continue;
                }
                // 更新存储距离start的最短路径的数组
                if (minDis[j] > minDis[index] + distance[index][j]) {
                    minDis[j] = minDis[index] + distance[index][j];
                }
            }
            // 标记index节点已访问
            visit[index] = true;
        }
        return minDis;
    }
}
