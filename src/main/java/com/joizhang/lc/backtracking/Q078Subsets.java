package com.joizhang.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 */
public class Q078Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, int start, ArrayList<Integer> track, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            backtrack(nums, i + 1, track, ans);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q078Subsets test = new Q078Subsets();
        System.out.println(test.subsets(new int[]{1, 2, 3}));
        System.out.println(test.subsets(new int[]{0}));
    }
}
