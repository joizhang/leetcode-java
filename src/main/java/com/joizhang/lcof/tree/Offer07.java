package com.joizhang.lcof.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 */
public class Offer07 {
    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 前序遍历性质：节点按照[根节点｜左子树｜右子树]排序
     * 中序遍历性质：节点按照[左子树｜根节点｜右子树]排序
     * 后序遍历性质：节点按照[左子树｜右子树｜根节点]排序
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) return null;

        TreeNode node = new TreeNode(preorder[preStart]);
        int inorderRootIndex = map.get(preorder[preStart]);
        int leftSize = inorderRootIndex - inStart;
        node.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, inorderRootIndex - 1);
        node.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, inorderRootIndex + 1, inEnd);
        return node;
    }

    public static void main(String[] args) {
        Offer07 test = new Offer07();
        Codec codec = new Codec();
        TreeNode root = test.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(codec.serialize(root));
    }
}
