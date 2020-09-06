package com.algorithm.week09;

/**
 * @author LX
 * 反转字符串中的单词 III
 */

public class ReverseWordsIII {

    public String reverseWords(String s) {
        if (s.length() == 0) return "";
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            str[i] = reverse(str[i]);
        }
        return s = String.join(" ",str);
    }

    public static String reverse(String s) {
        char[] a = s.toCharArray();
        int i = 0, j = a.length-1;
        while (i < j) {
            char tmp = a[i];// 交换字符串并移动指针
            a[i++] = a[j];
            a[j--] = tmp;
        }
        return String.valueOf(a);
    }


    public static void main(String[] args) {

        String s = "Let's take LeetCode contest";
        StringBuilder sbd = new StringBuilder(s);

        ReverseWords rw = new ReverseWords();
        rw.reverseEachWord(sbd);

        System.out.println(sbd.toString());

        //ReverseWordsIII r = new ReverseWordsIII();
        //System.out.println(r.reverseWords("abcd 1234"));
    }
}
