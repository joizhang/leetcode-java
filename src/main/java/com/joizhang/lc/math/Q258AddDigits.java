package com.joizhang.lc.math;

public class Q258AddDigits {

    public int addDigits(int num) {
        while (true) {
            int temp = 0;
            while (num != 0) {
                temp += num % 10;
                num /= 10;
            }
            if (temp < 10) return temp;
            else num = temp;
        }
    }
}
