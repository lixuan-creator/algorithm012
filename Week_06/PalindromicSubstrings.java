package com.algorithm.week06;

/**
 * @author LX
 * @version 1.0 2020/8/13
 * 回文子串
 */

public class PalindromicSubstrings {

    public static void main(String[] args) {
        PalindromicSubstrings ps = new PalindromicSubstrings();
        int result = ps.solution("aa");
        System.out.println(result);
    }

    // 动态规划
    public int solution(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int result = s.length();
        for (int i = 0;i<n; i++) dp[i][i] = true;
        for (int i = n-1; i>=0; i--) {
            for (int j = i+1; j<n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j-i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }

                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    result ++;
                }
            }
        }
        return result;
    }

    // 动态规划法
    public int solution2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    // 中心扩展法
    public int solution3(String s) {

        int ans = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            // left和right指针和中心点的关系是？
            // 首先是left，有一个很明显的2倍关系的存在，其次是right，可能和left指向同一个（偶数时），也可能往后移动一个（奇数）
            // 大致的关系出来了，可以选择带两个特殊例子进去看看是否满足。
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    // 暴力解法：思路清晰
    public int solution4(String s) {
        int ans = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            ans++;
            int l = i - 1, r = i + 1;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                ans++;
                l--;
                r++;
            }
            l = i - 1;
            r = i;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                ans++;
                l--;
                r++;
            }
        }
        return ans;
    }
}
