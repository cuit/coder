package com.xsc.coder.program;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xia
 * @date 2020/10/15 18:07
 */
public class CyclicBarrierTest {

    private static final ThreadFactory FACTORY = new ThreadFactoryBuilder()
            .setNameFormat("c-%d").build();

    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(20, 30,
            1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(100), FACTORY,
            new ThreadPoolExecutor.AbortPolicy());

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    public static void main(String[] args) {
        CyclicBarrierTest test = new CyclicBarrierTest();
        test.begin();
    }

    private class Person implements Runnable {

        private int result;

        public Person(int result) {
            this.result = result;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() +" is begin");
            try {
                Thread.sleep(result * 2000);
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is over " + System.currentTimeMillis());
        }
    }

    private void begin() {
        Random random = new Random();
        System.out.println("begin");
        for (int i = 0; i < 10; i++) {
            int result = random.nextInt(10) + 1;
            EXECUTOR_SERVICE.execute(new Person(result));
        }
        System.out.println("over");
    }

}
