package com.joizhang.lc.string;

public class Q1422MaximumScoreAfterSplittingAString {

    public int maxScore(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            int countZero = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == '0') countZero++;
            }
            int countOne = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '1') countOne++;
            }
            ans = Math.max(ans, countZero + countOne);
        }
        return ans;
    }

    public static void main(String[] args) {
        Q1422MaximumScoreAfterSplittingAString test = new Q1422MaximumScoreAfterSplittingAString();
        System.out.println(test.maxScore("011101"));
        System.out.println(test.maxScore("00111"));
        System.out.println(test.maxScore("1111"));
    }
}
