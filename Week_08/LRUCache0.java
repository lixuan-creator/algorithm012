package com.algorithm.week08;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author LX
 * @version 1.0 2020/8/25
 */

public class LRUCache0 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache0(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
