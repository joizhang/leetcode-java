package com.joizhang.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 */
public class Q093RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), ans);
        return ans;
    }

    private void backtrack(String s, int index, StringBuilder track, List<String> ans) {
        if (index > 4) return;
        if (index == 4 && s.isEmpty()) {
            ans.add(track.substring(0, track.length() - 1));
            return;
        }
        for (int i = 1; i < s.length() + 1; i++) {
            String substr = s.substring(0, i);
            double num = Double.parseDouble(substr);
            // 可以有单独的零，但是不能出现前导零
            if ("0".equals(substr) || (s.charAt(0) != '0' && num > 0 && num < 256)) {
                track.append(substr).append(".");
                backtrack(s.substring(i), index + 1, track, ans);
                track.delete(track.length() - substr.length() - 1, track.length());
            }
        }
    }

    public static void main(String[] args) {
        Q093RestoreIPAddress test = new Q093RestoreIPAddress();
        System.out.println(test.restoreIpAddresses("25525511135"));
        System.out.println(test.restoreIpAddresses("99999999999999999999"));
    }
}
