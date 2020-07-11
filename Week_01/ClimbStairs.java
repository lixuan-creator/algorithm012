package com.algorithm.week01;

import org.junit.Test;

/**
 * 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs
 */

public class ClimbStairs {

    @Test
    public void climbStairsTest() {

        System.out.println(climbStairs(1));
    }

    /**
     * 滚动数组：容易理解
     * 利用数组，太巧妙了
     * 链接：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
     * 时间复杂度：循环执行 n 次，每次花费常数的时间代价，故渐进时间复杂度为 O(n)。
     * 空间复杂度：这里只用了常数个变量作为辅助空间，故渐进空间复杂度为 O(1)。
     */
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * 经典：动态规划
     * 爬到第n级台阶是(n-1)级的方法数量+(n-2)级的方法数量
     * dp[0]，0级台阶比较特殊，国际站一种方法认为步数为0，这种特殊数据不应太较真，灵活些，应该根据具体写法灵活赋值
     * https://leetcode-cn.com/problems/climbing-stairs/solution/hua-jie-suan-fa-70-pa-lou-ti-by-guanpengchn/
     * 时间复杂度：循环(n-2)次，常见不计算，所以复杂度为O(n)
     * 空间复杂度：数组开辟了n个空间，O(n)所以空间复杂度O(n)
     */
    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }



}
