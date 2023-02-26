package com.joizhang.lc.backtracking;

import java.util.*;

/**
 * 39. 组合总和
 */
public class Q039CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // 排序是剪枝的前提
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> track, List<List<Integer>> ans) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 剪枝，前提是候选数组已经有序
            if (target < candidates[start]) break;
            track.add(candidates[i]);
            // 当前元素可以复用，所以参数start设为i
            backtrack(candidates, target - candidates[i], i, track, ans);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q039CombinationSum test = new Q039CombinationSum();
        System.out.println(test.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
