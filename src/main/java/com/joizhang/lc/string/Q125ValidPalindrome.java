package com.joizhang.lc.string;

/**
 * 125. 验证回文串
 */
public class Q125ValidPalindrome {
    public boolean isPalindrome(String s) {
        int n = s.length();
        s = s.toLowerCase();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i > j) break;
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Q125ValidPalindrome test = new Q125ValidPalindrome();
        System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(test.isPalindrome("race a car"));
        System.out.println(test.isPalindrome(" "));
        System.out.println(test.isPalindrome("OP"));
    }
}
