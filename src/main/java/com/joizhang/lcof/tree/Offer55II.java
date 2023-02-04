package com.joizhang.lcof.tree;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 */
public class Offer55II {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        // 若左右子树的差异小于等于1，返回子树的高度，否则返回-1
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }

    public static void main(String[] args) {
        Offer55II test = new Offer55II();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[3,9,20,null,null,15,7]");
        System.out.println(test.isBalanced(root));
        root = codec.deserialize("[1,2,2,3,3,null,null,4,4]");
        System.out.println(test.isBalanced(root));
    }
}
