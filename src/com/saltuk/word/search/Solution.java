package com.saltuk.word.search;

import java.util.*;

/**
 * 79-word-search
 */
class Solution {
    public boolean exist(char[][] board, String word) {

        var res = false;

        for(int x = 0; x < board.length; ++x) {
            for (int y = 0; y < board[0].length; ++y) {
                if (traceWord(board, word, 0, x, y)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean traceWord(char[][] board, String word, int idx, int x, int y) {
        if(idx >= word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(idx)) {
            return false;
        }

        var temp = board[x][y];

        board[x][y] = 0;

        var res = traceWord(board, word, idx + 1, x, y + 1) || traceWord(board, word, idx + 1, x, y - 1)
                || traceWord(board, word, idx + 1, x + 1, y) || traceWord(board, word, idx + 1, x - 1, y);

        board[x][y] = temp;

        return res;

    }
}