package com.joizhang.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 */
public class Q077Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), combinations);
        return combinations;
    }

    private void backtrack(int n, int k, int index, ArrayList<Integer> track, List<List<Integer>> combinations) {
        // 剪枝：track 长度加上区间 [index, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (track.size() + (n - index + 1) < k) return;
        if (track.size() == k) {
            combinations.add(new ArrayList<>(track));
            return;
        }
        for (int i = index; i <= n; i++) {
            track.add(i);
            backtrack(n, k, i + 1, track, combinations);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q077Combinations test = new Q077Combinations();
        System.out.println(test.combine(4, 2));
        System.out.println(test.combine(1, 1));
    }
}
