package com.xsc.coder.program;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xia
 * @date 2020/10/15 18:07
 */
public class CountDownLatchTest {

    private static final ThreadFactory FACTORY = new ThreadFactoryBuilder()
            .setNameFormat("c-%d").build();

    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(20, 30,
            1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(100), FACTORY,
            new ThreadPoolExecutor.AbortPolicy());

    private final CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) {
        CountDownLatchTest test = new CountDownLatchTest();
        test.begin();
    }

    private class Person implements Runnable {

        private final int result;

        public Person(int result) {
            this.result = result;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(result * 2000);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is over");
        }
    }

    private void begin() {
        Random random = new Random();
        System.out.println("begin");
        for (int i = 0; i < 10; i++) {
            int result = random.nextInt(10) + 1;
            EXECUTOR_SERVICE.execute(new Person(result));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }

}
