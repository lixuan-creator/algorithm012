package com.algorithm.week09;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LX
 * 同构字符串
 */

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    // Map映射
    public boolean isIsomorphicHelper(String s, String t) {
        Map<Character,Character> map = new HashMap();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }

    // 另一种思路
    private static String isIsomorphicHelper(String s) {
        int[] map = new int[128];
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //当前字母第一次出现,赋值
            if (map[c] == 0) {
                map[c] = count; // map[c] = i + 1; 直接映射为当前字母的下标加 1。因为 0 是我们的默认值
                count++;
            }
            sb.append(map[c]);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(isIsomorphicHelper("add").equals(isIsomorphicHelper("egg")));
    }

}
