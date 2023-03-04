package com.joizhang.lc.dp.array;

/**
 * 42. 接雨水
 */
public class Q042TrappingRainWater {
    //按列求
    public int trap(int[] height) {
        int sum = 0;
        // 最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            //找出左边最高
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }
            //找出右边最高
            int maxRight = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(maxLeft, maxRight);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    // 动态规划
    public int trap2(int[] height) {
        int sum = 0;
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Q042TrappingRainWater test = new Q042TrappingRainWater();
        System.out.println(test.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(test.trap(new int[]{4, 2, 0, 3, 2, 5}));

        System.out.println(test.trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(test.trap2(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
