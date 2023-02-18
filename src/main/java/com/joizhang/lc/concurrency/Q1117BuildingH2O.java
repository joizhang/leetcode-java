package com.joizhang.lc.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 1117. H2O 生成
 */
public class Q1117BuildingH2O {
    static class H2O {

        private final Semaphore h;
        private final Semaphore o;

        public H2O() {
            h = new Semaphore(2);
            o = new Semaphore(0);
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            h.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            o.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            o.acquire(2);
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            h.release(2);
        }
    }

    public static void main(String[] args) {
        H2O h2o = new H2O();
        ExecutorService executorService = Executors.newCachedThreadPool();
        String water = "OOHHHH";
        for (char c : water.toCharArray()) {
            if (c == 'H') {
                executorService.execute(() -> {
                    try {
                        h2o.hydrogen(() -> System.out.print(c));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            } else {
                executorService.execute(() -> {
                    try {
                        h2o.oxygen(() -> System.out.print(c));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
        executorService.shutdown();
    }
}
