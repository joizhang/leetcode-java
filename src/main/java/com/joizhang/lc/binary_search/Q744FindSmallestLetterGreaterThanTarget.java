package com.joizhang.lc.binary_search;

public class Q744FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] <= target) return letters[0];
        int lo = 0, hi = letters.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            // 如果当前下标处的字母大于目标字母，则在当前下标以及当前下标的左侧继续查找，否则在当前下标的右侧继续查找。
            if (letters[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return letters[lo];
    }

    public static void main(String[] args) {
        Q744FindSmallestLetterGreaterThanTarget test = new Q744FindSmallestLetterGreaterThanTarget();
        System.out.println(test.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
    }
}
