package com.joizhang.lc.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 */
public class Q113PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(TreeNode root, int targetSum, ArrayList<Integer> track, List<List<Integer>> ans) {
        if (root == null) return;
        if (root.left == null && root.right == null && targetSum == root.val) {
            track.add(root.val);
            ans.add(new ArrayList<>(track));
            track.remove(track.size() - 1);
            return;
        }

        track.add(root.val);
        dfs(root.left, targetSum - root.val, track, ans);
        dfs(root.right, targetSum - root.val, track, ans);
        track.remove(track.size() - 1);
    }


    public static void main(String[] args) {
        Q113PathSumII test = new Q113PathSumII();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        System.out.println(test.pathSum(root, 22));
    }
}
