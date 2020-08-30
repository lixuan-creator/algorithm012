package com.algorithm.week08;

/**
 * @author LX
 * 2的幕
 */

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n>0 &&(n & (n-1)) == 0;
    }
}

