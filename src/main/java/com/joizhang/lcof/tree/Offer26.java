package com.joizhang.lcof.tree;

/**
 * 剑指 Offer 26. 树的子结构
 */
public class Offer26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 约定空树不是任意一个树的子结构
        if (A == null || B == null) return false;
        // 以节点 A 为根节点的子树 包含树 B ，对应 recur(A, B)；
        // 树 B 是树 A 左子树的子结构，对应 isSubStructure(A.left, B)；
        // 树 B 是 树 A 右子树的子结构，对应 isSubStructure(A.right, B)
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
