package com.joizhang.lc.tree;

/**
 * 104. 二叉树的最大深度
 */
public class Q104MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Q104MaximumDepthOfBinaryTree test = new Q104MaximumDepthOfBinaryTree();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[3,9,20,null,null,15,7]");
        System.out.println(test.maxDepth(root));
    }
}
