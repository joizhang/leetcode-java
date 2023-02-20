package com.joizhang.lc.tree;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class Q108ConvertSortedArrayToBinaryTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, lo, mid - 1);
        root.right = dfs(nums, mid + 1, hi);
        return root;
    }

    public static void main(String[] args) {
        Q108ConvertSortedArrayToBinaryTree test = new Q108ConvertSortedArrayToBinaryTree();
        Codec codec = new Codec();
        TreeNode root = test.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(codec.serialize(root));
    }
}
