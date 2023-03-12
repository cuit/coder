package com.xsc.coder.program.y23.m03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xia
 * @date 2023/3/12 20:33
 */
public class CirclePrintTest {

    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();

    private Condition condition2 = lock.newCondition();

    private Condition condition3 = lock.newCondition();

    private int flag = 1;

    private static List<Character> charters = new ArrayList<>();

    {
        for (int i = 'a'; i <= 'z'; i++) {
            charters.add((char) i);
        }
    }

    private void print1() {
        lock.lock();
        try {
            while (charters.size() > 0) {
                while (flag != 1) {
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (charters.size()  == 0) {
                    break;
                }
                System.out.println("线程:" + Thread.currentThread().getName() + ":" + charters.get(0));
                charters.remove(0);
                flag = 2;
                condition2.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    private void print2() {
        lock.lock();
        try {
            while (charters.size() > 0) {
                while (flag != 2) {
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (charters.size()  == 0) {
                    break;
                }
                System.out.println("线程:" + Thread.currentThread().getName() + ":" + charters.get(0));
                charters.remove(0);
                flag = 3;
                condition3.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    private void print3() {
        lock.lock();
        try {
            while (charters.size() > 0) {
                while (flag != 3) {
                    try {
                        condition3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (charters.size()  == 0) {
                    break;
                }
                System.out.println("线程:" + Thread.currentThread().getName() + ":" + charters.get(0));
                charters.remove(0);
                flag = 1;
                condition1.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        CirclePrintTest printTest = new CirclePrintTest();
        new Thread(() -> printTest.print1()).start();
        new Thread(() -> printTest.print2()).start();
        new Thread(() -> printTest.print3()).start();
    }

}
