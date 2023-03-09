package com.joizhang.lc.dp.game;

/**
 * 123. Best Time to Buy and Sell Stock III
 */
public class Q123BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int s1 = -prices[0];
        int s2 = Integer.MIN_VALUE;
        int s3 = Integer.MIN_VALUE;
        int s4 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            s1 = Math.max(s1, -prices[i]);
            s2 = Math.max(s2, s1 + prices[i]);
            s3 = Math.max(s3, s2 - prices[i]);
            s4 = Math.max(s4, s3 + prices[i]);
        }
        return Math.max(0, s4);
    }

    public static void main(String[] args) {
        Q123BestTimeToBuyAndSellStockIII test = new Q123BestTimeToBuyAndSellStockIII();
        System.out.println(test.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(test.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(test.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(test.maxProfit(new int[]{1}));
    }
}
