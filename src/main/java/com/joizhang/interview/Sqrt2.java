package com.joizhang.interview;

public class Sqrt2 {

    private static final double EPSILON = 0.0000000001;

    public double sqrt2() {
        double low = 1.4, high = 1.5;
        double mid = (low + high) / 2;
        while (high - low > EPSILON) {
            if (mid * mid > 2) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (low + high) / 2;
        }
        return mid;
    }

    public double newton(double x) {
        if (Math.abs(x * x - 2) > EPSILON) {
            return newton(x - (x * x - 2) / (2 * x));
        } else {
            return x;
        }
    }

    public static void main(String[] args) {
        Sqrt2 test = new Sqrt2();
        System.out.println(test.sqrt2());
        System.out.println(test.newton(1.414));
    }
}
