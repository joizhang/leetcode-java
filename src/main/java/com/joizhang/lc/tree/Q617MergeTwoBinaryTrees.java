package com.joizhang.lc.tree;

/**
 * 617. 合并二叉树
 */
public class Q617MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        return recur(root1, root2);
    }

    private TreeNode recur(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = recur(root1.left, root2.left);
        root1.right = recur(root1.right, root2.right);
        return root1;
    }

    public static void main(String[] args) {
        Q617MergeTwoBinaryTrees test = new Q617MergeTwoBinaryTrees();
        Codec codec = new Codec();
        TreeNode root1 = codec.deserialize("[1,3,2,5]");
        TreeNode root2 = codec.deserialize("[2,1,3,null,4,null,7]");
        System.out.println(codec.serialize(test.mergeTrees(root1, root2)));
    }
}
