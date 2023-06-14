package com.saltuk.top.k.frequent.words;

import java.util.*;

/**
 * 692. Top K Frequent Words
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        var stat = new HashMap<String, Integer>();
        for(var word : words) {
            stat.put(word, stat.getOrDefault(word, 0) + 1);
        }
        var heap = new PriorityQueue<String>((w1 ,w2) -> {
            var s1 = stat.get(w1);
            var s2 = stat.get(w2);

            if (!Objects.equals(s2, s1)) {
                return s2 - s1;
            }
            return w1.compareTo(w2);
        });

        heap.addAll(stat.keySet());

        var res = new ArrayList<String>();
        for(int i = 0; i < k; i++) {
            res.add(heap.poll());
        }

        return res;
    }
}