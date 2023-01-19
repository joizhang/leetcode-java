package com.joizhang.lc.string;

/**
 * 171. Excel 表列序号
 */
public class Q171ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (char c : columnTitle.toCharArray()) {
            int temp = c - 'A' + 1;
            res = res * 26 + temp;
        }
        return res;
    }

    public static void main(String[] args) {
        Q171ExcelSheetColumnNumber test = new Q171ExcelSheetColumnNumber();
        System.out.println(test.titleToNumber("A"));
        System.out.println(test.titleToNumber("AB"));
        System.out.println(test.titleToNumber("ZY"));
    }
}
