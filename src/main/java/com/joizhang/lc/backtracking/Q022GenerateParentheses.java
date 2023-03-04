package com.joizhang.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class Q022GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0) return ans;
        backtrack(n, n, new StringBuilder(), ans);
        return ans;
    }

    private void backtrack(int left, int right, StringBuilder track, List<String> ans) {
        // 若left > right，说明有多的')'在'('前面，不符合要求
        if (left > right) return;
        // left < 0 || right < 0，说明括号的数量超过n
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            ans.add(track.toString());
            return;
        }

        track.append('(');
        backtrack(left - 1, right, track, ans);
        track.deleteCharAt(track.length() - 1);

        track.append(')');
        backtrack(left, right - 1, track, ans);
        track.deleteCharAt(track.length() - 1);
    }

    public static void main(String[] args) {
        Q022GenerateParentheses test = new Q022GenerateParentheses();
        System.out.println(test.generateParenthesis(1));
        System.out.println(test.generateParenthesis(2));
        System.out.println(test.generateParenthesis(3));
    }
}
