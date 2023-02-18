package com.joizhang.lc.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 1115. 交替打印 FooBar
 */
public class Q1115PrintFooBarAlternately {
    static class FooBar {
        private final int n;
        private final Semaphore semaphoreA;
        private final Semaphore semaphoreB;

        public FooBar(int n) {
            this.n = n;
            this.semaphoreA = new Semaphore(1);
            this.semaphoreB = new Semaphore(0);
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                this.semaphoreA.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                this.semaphoreB.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                this.semaphoreB.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                this.semaphoreA.release();
            }
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(2);
        Runnable printFoo = () -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable printBar = () -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(printFoo);
        executorService.execute(printBar);
        executorService.shutdown();
    }
}
