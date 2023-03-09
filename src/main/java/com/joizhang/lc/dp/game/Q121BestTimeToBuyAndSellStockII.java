package com.joizhang.lc.dp.game;

/**
 * 122. Best Time to Buy and Sell Stock II
 */
public class Q121BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }

    public static void main(String[] args) {
        Q121BestTimeToBuyAndSellStockII test = new Q121BestTimeToBuyAndSellStockII();
        System.out.println(test.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(test.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(test.maxProfit(new int[]{7,6,4,3,1}));
    }
}
