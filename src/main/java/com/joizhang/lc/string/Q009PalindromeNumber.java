package com.joizhang.lc.string;

/**
 * 9. 回文数
 */
public class Q009PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reverseNumber = 0;
        while (x > reverseNumber) {
            reverseNumber = reverseNumber * 10 + x % 10;
            x /= 10;
        }
        return x == reverseNumber || x == reverseNumber / 10;
    }

    public static void main(String[] args) {
        Q009PalindromeNumber test = new Q009PalindromeNumber();
        System.out.println(test.isPalindrome(121));
        System.out.println(test.isPalindrome(-121));
        System.out.println(test.isPalindrome(10));
    }
}
