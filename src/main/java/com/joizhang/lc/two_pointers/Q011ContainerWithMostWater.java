package com.joizhang.lc.two_pointers;

/**
 * 11. 盛最多水的容器
 */
public class Q011ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            res = Math.max(res, area);
            // 选定两板高度中的短板，向中间收窄一格；
            // 每轮向内移动短板，所有消去的状态都不会导致面积最大值丢失
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q011ContainerWithMostWater test = new Q011ContainerWithMostWater();
        System.out.println(test.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(test.maxArea(new int[]{1, 1}));
    }
}
