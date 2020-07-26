package com.algorithm.week03;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        // 首先是特判
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];// 记录每个位置使用情况
        List<Integer> path = new ArrayList<>();// 记录每一种情况

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        // new ArrayList<>(path):在 Java 中，因为都是值传递，对象类型变量在传参的过程中，复制的都是变量的地址。
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;// 标记该值已用

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations solution = new Permutations();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }




}
