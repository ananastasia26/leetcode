package com.saltuk.valid.parentheses;

import java.util.*;

/**
 * 20-valid-parentheses
 */
class Solution {
    public boolean isValid(String s) {

        var stack = new LinkedList<Character>();

        for(int i = 0; i < s.length(); ++i) {
            var symb = s.charAt(i);
            if(symb == '(' || symb == '[' || symb == '{') {
                stack.push(symb);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                var prevBrace = stack.pop();
                if((prevBrace != '(' && symb == ')')  || (prevBrace != '{' && symb == '}') || (prevBrace != '[' && symb == ']')) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}