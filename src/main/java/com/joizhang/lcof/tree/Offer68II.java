package com.joizhang.lcof.tree;

/**
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 */
public class Offer68II {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 当left和right同时为空：说明root的左右子树中都不包含p，q，返回null
        if (left == null && right == null) return null;
        // 当left为空，right不为空，p，q都不在root的左子树中，直接返回right
        if (left == null) return right;
        // 当left不为空，right为空
        if (right == null) return left;
        // 当left和right同时不为空：说明p，q分列在root的异侧
        return root;
    }

    public static void main(String[] args) {
        Offer68II test = new Offer68II();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode p = root.left;
        TreeNode q = root.right;
        TreeNode node = test.lowestCommonAncestor(root, p, q);
        System.out.println(codec.serialize(root));
    }
}
