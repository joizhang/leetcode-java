package com.joizhang.lc.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 1114. 按序打印
 */
public class Q1114PrintInOrder {
    static class Foo {

        private final Semaphore semaphoreA;
        private final Semaphore semaphoreB;

        public Foo() {
            semaphoreA = new Semaphore(0);
            semaphoreB = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            semaphoreA.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            semaphoreA.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            semaphoreB.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            semaphoreB.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.execute(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.execute(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.shutdown();
    }
}
