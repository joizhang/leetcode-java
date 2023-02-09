package com.joizhang.lcof.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 */
public class Offer34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        recur(root, target, new ArrayList<>(), ans);
        return ans;
    }

    private void recur(TreeNode root, int target, List<Integer> trace, List<List<Integer>> ans) {
        if (root == null) return;
        if (root.left == null && root.right == null && root.val == target) {
            trace.add(root.val);
            List<Integer> copy = new ArrayList<>(trace);
            ans.add(copy);
            trace.remove(trace.size() - 1);
            return;
        }
        target -= root.val;
        trace.add(root.val);
        recur(root.left, target, trace, ans);
        recur(root.right, target, trace, ans);
        trace.remove(trace.size() - 1);
    }

    public static void main(String[] args) {
        Offer34 test = new Offer34();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        System.out.println(test.pathSum(root, 22));
        root = codec.deserialize("[1,2,3]");
        System.out.println(test.pathSum(root, 3));
    }
}
