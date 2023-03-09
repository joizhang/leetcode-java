package com.joizhang.lc.dp.game;

/**
 * 121. Best Time to Buy and Sell Stock
 */
public class Q121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    public static void main(String[] args) {
        Q121BestTimeToBuyAndSellStock test = new Q121BestTimeToBuyAndSellStock();
        System.out.println(test.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(test.maxProfit(new int[]{7,6,4,3,1}));
    }
}
