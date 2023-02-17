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
        Runnable a = () -> {
            try {
                foo.first(() -> System.out.print("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable b = () -> {
            try {
                foo.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable c = () -> {
            try {
                foo.third(() -> System.out.print("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(c);
        executorService.execute(a);
        executorService.execute(b);
        executorService.shutdown();
    }
}
