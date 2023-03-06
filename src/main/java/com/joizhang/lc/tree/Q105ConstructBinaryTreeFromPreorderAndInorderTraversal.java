package com.joizhang.lc.tree;


import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class Q105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootIndex = map.get(preorder[preStart]);
        int leftSize = rootIndex - inStart;
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, rootIndex - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, rootIndex + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        Q105ConstructBinaryTreeFromPreorderAndInorderTraversal test =
                new Q105ConstructBinaryTreeFromPreorderAndInorderTraversal();
        Codec codec = new Codec();
        TreeNode root = test.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(codec.serialize(root));
    }
}
