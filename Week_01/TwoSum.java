package com.algorithm.week01;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数求和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 所以返回 [0, 1]
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {

    @Test
    public void twoSumTest() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 13;

        int[] ret = twoSum(nums, target);
        for (int i : ret) {
            System.out.println(i);
        }
    }

    /**
     * 经典
     * 利用哈希表存储的方法很巧妙，同时将两数和转化为比较两数的值，思路确实开阔
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/jie-suan-fa-1-liang-shu-zhi-he-by-guanpengchn/
     * 时间复杂度：O(n),只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间。
     * 空间复杂度：O(n),所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素。
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
