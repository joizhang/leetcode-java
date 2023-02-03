package com.joizhang.lcof.tree;

/**
 * 剑指 Offer 28. 对称的二叉树
 */
public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return recur(left.left, right.right) && recur(left.right, right.left);
    }

    public static void main(String[] args) {
        Offer28 test = new Offer28();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[1,2,2,3,4,4,3]");
        System.out.println(test.isSymmetric(root));
        root = codec.deserialize("[1,2,2,null,3,null,3]");
        System.out.println(test.isSymmetric(root));
    }
}
