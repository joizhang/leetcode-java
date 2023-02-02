package com.joizhang.lcof.tree;

/**
 * 剑指 Offer 26. 树的子结构
 */
public class Offer26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static void main(String[] args) {
        Offer26 test = new Offer26();
        Codec codec = new Codec();
        TreeNode A = codec.deserialize("[1,2,3]");
        TreeNode B = codec.deserialize("[3,1]");
        System.out.println(test.isSubStructure(A, B));

        A = codec.deserialize("[3,4,5,1,2]");
        B = codec.deserialize("[4,1]");
        System.out.println(test.isSubStructure(A, B));
    }

}
