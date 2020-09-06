package com.algorithm.week09;

import java.util.Stack;

/**
 * @author LX
 * 仅仅翻转字母
 */

public class ReverseOnlyLetters {

    // 字母栈
    public String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack();
        for (char c: S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }

        return ans.toString();
    }

    // 反转指针
    public String reverseOnlyLetters2(String S) {
        StringBuilder ans = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); ++i) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j)))
                    j--;
                ans.append(S.charAt(j--));
            } else {
                ans.append(S.charAt(i));
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        ReverseOnlyLetters rol = new ReverseOnlyLetters();

        System.out.println(rol.reverseOnlyLetters(s));
        System.out.println(rol.reverseOnlyLetters2(s));
    }

}
