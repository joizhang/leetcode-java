package com.joizhang.lc.tree;

/**
 * 96. 不同的二叉搜索树
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees/solution/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b/">...</a>
 *
 * <p>假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
 *
 * <p>G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
 *
 * <p>当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
 *
 * <p>f(i)=G(i−1)∗G(n−i)
 *
 * <p>综合两个公式可以得到 卡特兰数 公式
 *
 * <p>G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
 */
public class Q096UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // 状态定义:dp[i]为当有i个节点时,一共可以组成的二叉搜索树数目
        // 状态转移:dp[3]=dp[0]*dp[2]+dp[1]*dp[1]+dp[2]*dp[0]
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Q096UniqueBinarySearchTrees test = new Q096UniqueBinarySearchTrees();
        System.out.println(test.numTrees(3));
        System.out.println(test.numTrees(1));
    }
}
