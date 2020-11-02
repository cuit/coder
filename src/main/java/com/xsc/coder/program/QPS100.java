package com.xsc.coder.program;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 实现一个单机限流器，要求每秒钟只能通过100个请求。也就是限制QPS<=100。
 *
 * @author xia
 * @date 2020/11/2 17:06
 */
public class QPS100 {

    private static Queue<Long> queue = new ConcurrentLinkedDeque<>();

    public static boolean tryAcquire() {
        long timestamp = System.currentTimeMillis();
        queue.add(timestamp);
        if (queue.size() <= 100) {
            return true;
        } else {
            Iterator<Long> iteator = queue.iterator();
            while (iteator.hasNext()) {
                long val = iteator.next();
                if (timestamp - val >= 1000) {
                    iteator.remove();
                } else {
                    break;
                }
            }
            return queue.size() <= 100;
        }
    }

}
