package com.joizhang.lc.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 1116. 打印零与奇偶数
 */
public class Q1116PrintZeroEvenOdd {
    static class ZeroEvenOdd {
        private final int n;
        private final Semaphore zero;
        private final Semaphore odd;
        private final Semaphore even;

        public ZeroEvenOdd(int n) {
            this.n = n;
            zero = new Semaphore(1);
            odd = new Semaphore(0);
            even = new Semaphore(0);
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                zero.acquire();
                printNumber.accept(0);
                if (i % 2 != 0) {
                    odd.release();
                } else {
                    even.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if ((i & 1) == 0) {
                    even.acquire();
                    printNumber.accept(i);
                    zero.release();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if ((i & 1) == 1) {
                    odd.acquire();
                    printNumber.accept(i);
                    zero.release();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        Runnable zero = () -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable even = () -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable odd = () -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(odd);
        executorService.execute(even);
        executorService.execute(zero);
        executorService.shutdown();
    }
}
