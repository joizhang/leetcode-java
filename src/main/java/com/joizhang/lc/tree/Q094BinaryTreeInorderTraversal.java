package com.joizhang.lc.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 */
public class Q094BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        dfs(root.left, ans);
        ans.add(root.val);
        dfs(root.right, ans);
    }

    public static void main(String[] args) {
        Q094BinaryTreeInorderTraversal test = new Q094BinaryTreeInorderTraversal();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[1,null,2,3]");
        System.out.println(test.inorderTraversal(root));
    }
}
