package com.algorithm.week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 字母异位词分组
 */

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs){
        // 定义map
        HashMap<String,List> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String charsKey = String.valueOf(chars);
            // 维护一个映射 map : {String -> List}
            if (!map.containsKey(charsKey)) {
                map.put(charsKey,new ArrayList());
                map.get(charsKey).add(str);
            }
        }
        return new ArrayList(map.values());
    }
}
