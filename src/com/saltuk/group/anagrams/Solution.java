package com.saltuk.group.anagrams;

import java.util.*;

/**
 * 49-group-anagrams
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var lettersToWords = new HashMap<String, List<String>>();

        for (String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);

            var sortedLetters = new String(charArray);

            if (!lettersToWords.containsKey(sortedLetters)) {
                lettersToWords.put(sortedLetters, new ArrayList<>());
            }
            var anagrams = lettersToWords.get(sortedLetters);
            anagrams.add(word);
        }

        return lettersToWords.values().stream().toList();
    }
}