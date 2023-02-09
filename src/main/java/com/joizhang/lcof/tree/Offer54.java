package com.joizhang.lcof.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 */
public class Offer54 {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> trace = new ArrayList<>();
        recur(root, trace);
        return trace.get(trace.size() - k);
    }

    private void recur(TreeNode root, List<Integer> trace) {
        if (root == null) return;
        recur(root.left, trace);
        trace.add(root.val);
        recur(root.right, trace);
    }

    // 中序遍历 + 提前返回
    int res, k;
    public int kthLargest2(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }

    public static void main(String[] args) {
        Offer54 test = new Offer54();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[3,1,4,null,2]");
        System.out.println(test.kthLargest(root, 1));
        root = codec.deserialize("[5,3,6,2,4,null,null,1]");
        System.out.println(test.kthLargest(root, 3));

        root = codec.deserialize("[3,1,4,null,2]");
        System.out.println(test.kthLargest2(root, 1));
        root = codec.deserialize("[5,3,6,2,4,null,null,1]");
        System.out.println(test.kthLargest2(root, 3));
    }
}
