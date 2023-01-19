package com.joizhang.lcof.string;

/**
 * 剑指 Offer 05. 替换空格
 */
public class Offer05 {
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    public static void main(String[] args) {
        Offer05 test = new Offer05();
        System.out.println(test.replaceSpace("We are happy."));
    }
}
