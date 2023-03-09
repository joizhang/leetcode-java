package com.joizhang.lc.tree;

/**
 * 543. 二叉树的直径
 * 二叉树的直径是指树中任意两个相聚最远结点的长度，
 * 结点之间的长度通过结点之间的边的数量得到
 */
public class Q543DiameterOfBinaryTree {
    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        recur(root);
        // 计算结果的ans求的是节点的个数，为了返回线段个数需要-1
        return ans - 1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        int right = recur(root.right);
        // 求出当前的路径长度
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Q543DiameterOfBinaryTree test = new Q543DiameterOfBinaryTree();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[1,2,3,4,5]");
        System.out.println(test.diameterOfBinaryTree(root));
    }
}
