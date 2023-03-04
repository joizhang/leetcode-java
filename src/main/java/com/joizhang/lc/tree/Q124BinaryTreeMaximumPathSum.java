package com.joizhang.lc.tree;

/**
 * 124. 二叉树中的最大路径和
 */
public class Q124BinaryTreeMaximumPathSum {
    private int ans;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        recur(root);
        return ans;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int leftSum = Math.max(0, recur(root.left));
        int rightSum = Math.max(0, recur(root.right));
        ans = Math.max(ans, leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }

    public static void main(String[] args) {
        Q124BinaryTreeMaximumPathSum test = new Q124BinaryTreeMaximumPathSum();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[1,2,3]");
        System.out.println(test.maxPathSum(root));
        root = codec.deserialize("[-10,9,20,null,null,15,7]");
        System.out.println(test.maxPathSum(root));
    }
}
