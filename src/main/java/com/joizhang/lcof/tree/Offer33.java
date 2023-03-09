package com.joizhang.lcof.tree;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    // 通过递归，判断所有子树的正确性
    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        //  找到postorder[j]的左右子树的中间位置 m
        //  postorder[i,...,m-1] < postorder[j]
        //  postorder[m,...,j-1] > postorder[j]
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
