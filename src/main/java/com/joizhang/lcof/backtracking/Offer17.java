package com.joizhang.lcof.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        List<Integer> ans = new ArrayList<>();
        backtrack(n, ans, new StringBuilder());
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void backtrack(int n, List<Integer> ans, StringBuilder track) {
        if (n == 0) {
            int num = Integer.parseInt(track.toString());
            if (num != 0) {
                ans.add(num);
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            track.append(i);
            backtrack(n - 1, ans, track);
            track.deleteCharAt(track.length() - 1);
        }
    }

    public static void main(String[] args) {
        Offer17 test = new Offer17();
        System.out.println(test.printNumbers(1).length);
        System.out.println(Arrays.toString(test.printNumbers(1)));
        System.out.println(test.printNumbers(2).length);
        System.out.println(Arrays.toString(test.printNumbers(2)));
        System.out.println(test.printNumbers(3).length);
    }
}
