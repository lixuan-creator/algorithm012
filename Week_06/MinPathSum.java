package com.algorithm.week06;

/**
 * @author LX
 * @version 1.0 2020/8/13
 * 最小路径和
 */

public class MinPathSum {


    public int solution (int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        // 第一排值等于左方相邻元素的最小路径加上当前元素的值
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        // 第一列值等于上方相邻元素的最小路径加上当前元素的值
        for (int j = 1;j < columns; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        // 对于不在第一行和第一列的元素,等于左方或者上方最小路径值加上当前元素值
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[rows-1][columns-1];
    }
}
