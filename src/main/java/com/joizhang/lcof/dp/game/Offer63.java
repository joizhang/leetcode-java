package com.joizhang.lcof.dp.game;

/**
 * 剑指 Offer 63. 股票的最大利润
 */
public class Offer63 {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    public static void main(String[] args) {
        Offer63 test = new Offer63();
        System.out.println(test.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(test.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
