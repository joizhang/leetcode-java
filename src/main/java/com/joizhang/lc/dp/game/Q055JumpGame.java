package com.joizhang.lc.dp.game;

/**
 * 55. Jump Game
 */
public class Q055JumpGame {
    public boolean canJump(int[] nums) {
        int goal = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            goal = Math.max(goal, nums[i] + i);
            if (goal <= i) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Q055JumpGame test = new Q055JumpGame();
        System.out.println(test.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(test.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(test.canJump(new int[]{0, 1}));
        System.out.println(test.canJump(new int[]{2, 0}));
        System.out.println(test.canJump(new int[]{2, 0, 0}));
    }
}
