package com.joizhang.lc.backtracking;

import java.util.*;

/**
 * 40. 组合总和 II
 */
public class Q040CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> track, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 剪枝
            if (target < candidates[start]) break;
            // 去重
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            track.add(candidates[i]);
            // 每个数字在每个组合中只能使用一次
            backtrack(candidates, target - candidates[i], i + 1, track, ans);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q040CombinationSumII test = new Q040CombinationSumII();
        System.out.println(test.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
