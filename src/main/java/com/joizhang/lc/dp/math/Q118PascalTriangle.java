package com.joizhang.lc.dp.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 */
public class Q118PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    int a = res.get(i - 1).get(j - 1);
                    int b = res.get(i - 1).get(j);
                    temp.add(a + b);
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        Q118PascalTriangle test = new Q118PascalTriangle();
        System.out.println(test.generate(5));
    }
}
