package com.joizhang.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. 格雷编码
 */
public class Q089GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = ans.size() - 1; j >= 0;j--) {
                ans.add(head + ans.get(j));
            }
            head <<= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Q089GrayCode test = new Q089GrayCode();
        System.out.println(test.grayCode(2));
        System.out.println(test.grayCode(1));
        System.out.println(test.grayCode(10));
    }
}
