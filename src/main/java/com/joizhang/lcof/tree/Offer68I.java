package com.joizhang.lcof.tree;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 */
public class Offer68I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 若root是p，q的最近公共祖先，则只可能为一下情况之一：
        // 1. p和q在root的子树中，且分列root的异侧（即分别在左、右子树中）
        // 2. p = root，且q在root的左或右子树中
        // 3. q = root，且p在root的左或右子树中
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        Offer68I test = new Offer68I();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[6,2,8,0,4,7,9,null,null,3,5]");
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        TreeNode node = test.lowestCommonAncestor(root, p, q);
        System.out.println(codec.serialize(node));
    }
}
