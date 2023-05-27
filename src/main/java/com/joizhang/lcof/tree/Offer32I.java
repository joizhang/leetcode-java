package com.joizhang.lcof.tree;

import java.util.*;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 */
public class Offer32I {

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Offer32I test = new Offer32I();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[3,9,20,null,null,15,7]");
        System.out.println(Arrays.toString(test.levelOrder(root)));
    }

}
