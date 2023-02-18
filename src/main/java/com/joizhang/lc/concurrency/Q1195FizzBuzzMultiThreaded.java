package com.joizhang.lc.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 1195. 交替打印字符串
 */
public class Q1195FizzBuzzMultiThreaded {
    static class FizzBuzz {
        private final int n;
        private final Semaphore sNum;
        private final Semaphore sFizzbuzz;
        private final Semaphore sBuzz;
        private final Semaphore sFizz;

        public FizzBuzz(int n) {
            this.n = n;
            sNum = new Semaphore(1);
            sFizzbuzz = new Semaphore(0);
            sBuzz = new Semaphore(0);
            sFizz = new Semaphore(0);
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 3; i <= n; i += 3) {
                if (i % 5 == 0) continue;
                sFizz.acquire();
                printFizz.run();
                sNum.release();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 5; i <= n; i += 5) {
                if (i % 3 == 0) continue;
                sBuzz.acquire();
                printBuzz.run();
                sNum.release();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 15; i <= n; i += 15) {
                sFizzbuzz.acquire();
                printFizzBuzz.run();
                sNum.release();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                sNum.acquire();
                if (i % 15 == 0) {
                    sFizzbuzz.release();
                } else if (i % 5 == 0) {
                    sBuzz.release();
                } else if (i % 3 == 0) {
                    sFizz.release();
                } else {
                    printNumber.accept(i);
                    sNum.release();
                }
            }
        }
    }


    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Runnable a = () -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable b = () -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable c = () -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable d = () -> {
            try {
                fizzBuzz.number(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(a);
        executorService.execute(b);
        executorService.execute(c);
        executorService.execute(d);
        executorService.shutdown();
    }
}
