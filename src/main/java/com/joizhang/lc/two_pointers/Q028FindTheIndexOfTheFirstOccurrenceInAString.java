package com.joizhang.lc.two_pointers;

/**
 * 28. Find the Index of the First Occurrence in a String
 */
public class Q028FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.length() == needle.length()) {
            return haystack.equals(needle) ? 0 : -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int hIndex = i, nIndex = 0;
            while (hIndex < haystack.length() && nIndex < needle.length() &&
                    haystack.charAt(hIndex) == needle.charAt(nIndex)) {
                hIndex++;
                nIndex++;
            }
            if (nIndex == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q028FindTheIndexOfTheFirstOccurrenceInAString test = new Q028FindTheIndexOfTheFirstOccurrenceInAString();
        System.out.println(test.strStr("sadbutsad", "sad"));
        System.out.println(test.strStr("leetcode", "leeto"));
        System.out.println(test.strStr("leetcode", "de"));
    }
}
