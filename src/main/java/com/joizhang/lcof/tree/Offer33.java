package com.joizhang.lcof.tree;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    public static void main(String[] args) {
        Offer33 test = new Offer33();
        System.out.println(test.verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        System.out.println(test.verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }
}
