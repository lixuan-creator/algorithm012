package com.algorithm.week06;

/**
 * @author LX
 * @version 1.0 2020/8/13
 * 最大正方形
 */

public class MaximalSquare {

    /**
     * 用 dp(i,j)表示以 (i,j) 为右下角,且只包含 1 的正方形的边长最大值
     * 如果该位置的值是 0，则 dp(i,j)=0，因为当前位置不可能在由 1 组成的正方形中
     * i 和 j 中至少有一个为 0，则以位置 (i,j) 为右下角的最大正方形的边长只能是 1，因此 dp(i,j)=1
     * 当前位置的元素值等于三个相邻位置的元素中的最小值加 1，状态转移方程如下：dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
     */
    public int solution(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length==0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
}
