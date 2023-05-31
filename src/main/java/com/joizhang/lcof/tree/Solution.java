package com.joizhang.lcof.tree;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd,
                           Map<Integer, Integer> map) {
        if (preStart > preEnd) return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int rootIndex = map.get(preorder[preStart]);
        int leftSize = rootIndex - inStart;
        node.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, rootIndex - 1, map);
        node.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, rootIndex + 1, inEnd, map);
        return node;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        Codec codec = new Codec();
        TreeNode root = test.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(codec.serialize(root));
    }
}
