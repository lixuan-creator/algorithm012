package com.algorithm.week09;

/**
 * @author LX
 * 验证回文字符串II
 */

public class ValidPalindrome {

    // 贪心算法 左右指针
    // s[low]==s[high]
    // s[low+1]==s[high] || s[low]==s[high-1]
    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                low++;
                high--;
            } else {
                boolean flag1 = true, flag2 = true;
                for (int i = low, j = high - 1; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = low + 1, j = high; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }

    // 简化代码
    public boolean validPalindrome1(String s) {
        for(int i = 0, j = s.length()-1; i < j ; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                //分两种情况，一是右边减一，二是左边加一
                return isPalindrome(s,i,j-1) || isPalindrome(s, i+1, j);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }


    // 其他思路
    public static boolean validPalindrome2(String s) {
        int l = 0, r = s.length() - 1;
        boolean deleteL = false, deleteR = false;
        while(r > l) {
            if(s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
                continue;
            }
            if(!deleteL) {
                l++;
                deleteL = true;
            } else if(!deleteR) {
                r--;
                l--;
                deleteR = true;
            } else {
                return false;
            }
        }
        return true;
    }

    // 递归
    public boolean validPalindrome4(String s) {
        return validPalindrome(s, 0, s.length()-1, 1);
    }

    /**
     * 递归
     * @param s 输入字符串
     * @param left 左指针
     * @param right 右指针
     * @param chance 删除节点的机会次数
     */
    private boolean validPalindrome(String s, int left, int right, int chance) {
        if (left > right) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return validPalindrome(s, left + 1, right - 1, chance);
        } else {
            if (chance == 0) {
                return false;
            }
            return validPalindrome(s, left, right - 1, chance-1) || validPalindrome(s, left + 1, right, chance-1);
        }
    }


    public static void main(String[] args) {
        System.out.println(validPalindrome2("cbbac"));
    }
}
