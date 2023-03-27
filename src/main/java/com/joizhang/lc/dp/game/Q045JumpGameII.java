package com.joizhang.lc.dp.game;

/**
 * 45. 跳跃游戏 II
 */
public class Q045JumpGameII {
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        Q045JumpGameII test = new Q045JumpGameII();
        System.out.println(test.jump(new int[]{2, 3, 1, 1, 4}));
    }
}
