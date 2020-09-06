package com.algorithm.week09;

/**
 * @author LX
 * 反转字符串 II
 */

public class ReverseStringII {

    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {// 每次递增2k步长
            int i = start, j = Math.min(start + k - 1, a.length - 1);// start+k-1前半部分最后一个
            while (i < j) {
                char tmp = a[i];// 交换字符串并移动指针
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}
