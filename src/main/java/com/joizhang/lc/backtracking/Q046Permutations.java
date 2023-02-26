package com.joizhang.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 */
public class Q046Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 可以去掉 visited，然后用track.contains(nums[i])来判断
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

            track.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, track, ans);
            visited[i] = false;
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q046Permutations test = new Q046Permutations();
        System.out.println(test.permute(new int[]{1, 2, 3}));
    }
}
