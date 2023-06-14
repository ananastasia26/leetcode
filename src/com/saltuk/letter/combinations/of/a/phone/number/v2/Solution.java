package com.saltuk.letter.combinations.of.a.phone.number.v2;

import java.util.*;

/**
 * 17-Letter-Combinations-of-a-Phone-Number
 */
class Solution {
    private static final Map<String, List<String>> digitToLetters = Map.of("2", List.of("a", "b", "c"),
            "3", List.of("d", "e", "f"),
            "4", List.of("g", "h", "i"),
            "5", List.of("j", "k", "l"),
            "6", List.of("m", "n", "o"),
            "7", List.of("p", "q", "r", "s"),
            "8", List.of("t", "u", "v"),
            "9", List.of("w", "x", "y", "z"));

    public List<String> letterCombinations(String digits) {
        var res = new ArrayList<String>();

        if (digits.length() > 0) {
            makeCombinations(digits, "", 0, res);
        }

        return res;
    }

    private void makeCombinations(String digits, String currentLetters, int idx, List<String> res) {
        if(idx == digits.length()) {
            res.add(currentLetters);
            return;
        }

        var currentDigit = Character.toString(digits.charAt(idx));
        var correspondingLetters = digitToLetters.get(currentDigit);
        for(var letter : correspondingLetters) {
            makeCombinations(digits, currentLetters + letter, idx + 1, res);
        }
    }
}