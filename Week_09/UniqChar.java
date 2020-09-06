package com.algorithm.week09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LX
 * 字符串中的第一个唯一字符
 */

public class UniqChar {
    // 暴力求解
    public int firstUniqChar(String s) {
        if (s.length() == 0) return -1;
        Set set = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            boolean flag = false;
            if (set.contains(s.charAt(i))) continue;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    set.add(s.charAt(i));
                    flag = true;
                }
            }
            if (!flag) return i;
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

}
