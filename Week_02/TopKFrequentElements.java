package com.algorithm.week02;

import java.util.*;

/**
 * 前K个高频元素
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {

        // 构建哈希映射：字符及其出现频率
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // 这是个小顶堆
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // 在堆中保留k个最频繁的元素
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // 构建输出列表
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3,3,3,3};
        List<Integer> list = new TopKFrequentElements().topKFrequent(nums,2);
        list.forEach(System.out::println);
    }

}

