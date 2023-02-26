package com.joizhang.lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 */
public class Q047PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> track, List<List<Integer>> ans) {
        if (track.size() == nums.length) {
            ans.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;
            track.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, track, ans);
            visited[i] = false;
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q047PermutationsII test = new Q047PermutationsII();
        System.out.println(test.permuteUnique(new int[]{1, 1, 2}));
        System.out.println(test.permuteUnique(new int[]{1, 2, 3}));
    }
}
