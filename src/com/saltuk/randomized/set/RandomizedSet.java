package com.saltuk.randomized.set;

import java.util.*;

/**
 * 380. Randomized Set
 */
class RandomizedSet {
    private List<Integer> elements = new ArrayList<>();
    private Map<Integer, Integer> elementToIdx = new HashMap<>();
    private final Random randomizer = new Random(System.currentTimeMillis());

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (elementToIdx.containsKey(val)) {
            return false;
        }

        var idx = elements.size();
        elements.add(val);
        elementToIdx.put(val, idx);
        return true;
    }

    public boolean remove(int val) {
        if (!elementToIdx.containsKey(val)) {
            return false;
        }
        var valIdx = elementToIdx.get(val);

        var lastIdx = elements.size() - 1;
        var lastValue = elements.remove(lastIdx);
        if (lastIdx != valIdx) {
            elements.set(valIdx, lastValue);
            elementToIdx.put(lastValue, valIdx);
        }
        elementToIdx.remove(val);

        return true;
    }

    public int getRandom() {
        var randomIdx = randomizer.nextInt(elements.size());
        return elements.get(randomIdx);
    }
}

/**
 * Your com.saltuk.randomized.set.RandomizedSet object will be instantiated and called as such:
 * com.saltuk.randomized.set.RandomizedSet obj = new com.saltuk.randomized.set.RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */