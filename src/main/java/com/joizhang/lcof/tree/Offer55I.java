package com.joizhang.lcof.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 */
public class Offer55I {
    /**
     * 后序遍历
     */
    public int maxDepth(TreeNode root) {
        // 树的深度等于左子树的深度与右子树的深度的最大值+1
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 层序遍历
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth += 1;
        }
        return depth;
    }

    public static void main(String[] args) {
        Offer55I test = new Offer55I();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[3,9,20,null,null,15,7]");
        System.out.println(test.maxDepth(root));
    }
}
