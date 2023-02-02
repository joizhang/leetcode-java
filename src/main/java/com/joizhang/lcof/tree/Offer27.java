package com.joizhang.lcof.tree;

/**
 * 剑指 Offer 27. 二叉树的镜像
 */
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode leftRoot = mirrorTree(root.right);
        TreeNode rightRoot = mirrorTree(root.left);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }

    public static void main(String[] args) {
        Offer27 test = new Offer27();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[4,2,7,1,3,6,9]");
        root = test.mirrorTree(root);
        System.out.println(codec.serialize(root));
    }
}
