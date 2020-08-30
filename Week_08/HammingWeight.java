package com.algorithm.week08;

/**
 * @author LX
 * 位1的个数
 */

public class HammingWeight {
    public int solution(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 30; i++) {
            if ((mask & n) != 0) {
                bits ++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
