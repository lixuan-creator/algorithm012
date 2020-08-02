package com.algorithm.week04;

import java.util.Arrays;

/**
 * 分发饼干
 */

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s)
    {
        Arrays.sort(g);// 孩子胃口
        Arrays.sort(s);// 饼干大小
        int i = 0;
        int j = 0;
        int count = 0;// 统计数据
        while (i < g.length && j < s.length)
        {
            if(s[j] >= g[i])
            {
                // 饼干大小大于小朋友口味
                count++;
                i++;
            }
            j++;// 换饼干
        }
        return count;
    }
}
