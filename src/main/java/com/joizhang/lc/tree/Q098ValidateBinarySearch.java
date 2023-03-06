package com.joizhang.lc.tree;

/**
 * 98. 验证二叉搜索树
 */
public class Q098ValidateBinarySearch {
    public boolean isValidBST(TreeNode root) {
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validBST(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (!(lower < root.val && root.val < upper)) {
            return false;
        }
        return validBST(root.left, lower, root.val) && validBST(root.right, root.val, upper);
    }

    public static void main(String[] args) {
        Q098ValidateBinarySearch test = new Q098ValidateBinarySearch();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[2,1,3]");
        System.out.println(test.isValidBST(root));
        root = codec.deserialize("[1,2,3]");
        System.out.println(test.isValidBST(root));
        root = codec.deserialize("[5,1,4,null,null,3,6]");
        System.out.println(test.isValidBST(root));
        root = codec.deserialize("[5,4,6,null,null,3,7]");
        System.out.println(test.isValidBST(root));
        root = codec.deserialize("[2147483647]");
        System.out.println(test.isValidBST(root));
    }
}
