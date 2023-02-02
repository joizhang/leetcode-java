package com.joizhang.lcof.tree;

import java.util.*;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 */
public class Offer32III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> temp = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (level % 2 != 0) {
                Collections.reverse(temp);
            }
            res.add(temp);
            level += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer32III test = new Offer32III();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[3,9,20,null,null,15,7]");
        System.out.println(test.levelOrder(root));
    }
}
