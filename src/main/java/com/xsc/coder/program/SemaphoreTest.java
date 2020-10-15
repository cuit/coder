package com.xsc.coder.program;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xia
 * @date 2020/10/15 19:29
 */
public class SemaphoreTest {

    private static final ThreadFactory FACTORY = new ThreadFactoryBuilder()
            .setNameFormat("c-%d").build();

    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(10, 30,
            1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(10), FACTORY,
            new ThreadPoolExecutor.AbortPolicy());

    private final Semaphore semaphore = new Semaphore(5);

    private class Person implements Runnable {

        private final int result;

        public Person(int result) {
            this.result = result;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+" is begin "+ new Date());
                Thread.sleep(result * 3000);
                System.out.println(Thread.currentThread().getName()+" is over " + new Date());
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void begin() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            EXECUTOR_SERVICE.execute(new Person(random.nextInt(4) + 1));
        }
    }

    public static void main(String[] args) {
        System.out.println("begin "+ new Date());
        SemaphoreTest test = new SemaphoreTest();
        test.begin();
        System.out.println("over "+new Date());
    }

}
