package com.joizhang.lc.dp.array;

/**
 * 55. 跳跃游戏
 */
public class Q055JumpGame {
    // 1,1,0,1
    public boolean canJump(int[] nums) {
        int goal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > goal) return false;
            goal = Math.max(goal, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Q055JumpGame test = new Q055JumpGame();
        System.out.println(test.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(test.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
