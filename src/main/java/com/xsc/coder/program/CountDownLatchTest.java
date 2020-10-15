package com.xsc.coder.program;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author xia
 * @date 2020/10/15 18:07
 */
public class CountDownLatchTest {

    private CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) {
        CountDownLatchTest test = new CountDownLatchTest();
        test.begin();
    }

    private class Person implements Runnable {

        private int result;

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
            System.out.println(Thread.currentThread().getName()+" is over");
        }
    }

    private void begin() {
        Random random = new Random();
        System.out.println("begin");
        for (int i = 0; i < 10; i++) {
            int result = random.nextInt(10) + 1;
            new Thread(new Person(result)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }

}
