package com.xsc.coder.program;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xia
 * @date 2020/11/2 18:35
 */
public class T {

    private static final ScheduledExecutorService e = new ScheduledThreadPoolExecutor(3,
            new ThreadFactoryBuilder().setNameFormat("%d").build());

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            e.scheduleAtFixedRate(() -> {
                System.out.println(Thread.currentThread().getName() + "开始执行" + System.currentTimeMillis());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行结束" + System.currentTimeMillis());
            }, 1, 2, TimeUnit.SECONDS);
        }
    }
}
