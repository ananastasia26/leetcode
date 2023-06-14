package com.saltuk.top.k.frequent.elements;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var stat = new HashMap<Integer, Integer>();
        for(var num : nums) {
            stat.put(num, stat.getOrDefault(num, 0) + 1);
        }
        var heap = new PriorityQueue<Integer>((i1, i2) -> stat.get(i2) - stat.get(i1));
        for(var key : stat.keySet()) {
            heap.add(key);
        }
        var res = new int[k];
        for(int i = 0; i < k; ++i) {
            res[i] = heap.poll();
        }

        return res;
    }
}