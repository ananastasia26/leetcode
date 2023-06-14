package com.saltuk.generate.parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * 22-generate-parentheses
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        return generate(new ParenthesesState(), n);
    }

    private List<String> generate(ParenthesesState state, int n) {
        if (state.getCurrentPairs() == n) {
            var res = new ArrayList<String>();
            res.add(state.getString());
            return res;
        }
        if(state.getNotClosed() == 0) {
            state.addOpenBrace();
            return generate(state, n);
        }

        var res = new ArrayList<String>();
        if(state.getUsedOpenBraces() < n) {
            var anotherState = new ParenthesesState(state);
            anotherState.addOpenBrace();
            var subRes = generate(anotherState, n);
            res.addAll(subRes);
        }

        state.addCloseBrace();
        var subRes = generate(state, n);
        res.addAll(subRes);

        return res;
    }

    class ParenthesesState {
        private int notClosed = 0;
        private int currentPairs = 0;
        private StringBuilder str = new StringBuilder();
        private int usedOpenBraces = 0;

        ParenthesesState() {

        }

        ParenthesesState(ParenthesesState state) {
            this.notClosed = state.notClosed;
            this.currentPairs = state.currentPairs;
            this.usedOpenBraces = state.usedOpenBraces;
            this.str = new StringBuilder(state.str);
        }

        public int getCurrentPairs() {
            return currentPairs;
        }

        public int getNotClosed() {
            return notClosed;
        }

        public int getUsedOpenBraces() {
            return usedOpenBraces;
        }

        public void addOpenBrace() {
            str.append('(');
            usedOpenBraces++;
            notClosed++;
        }

        public void addCloseBrace() {
            str.append(')');
            notClosed--;
            currentPairs++;
        }

        public String getString() {
            return str.toString();
        }
    }
}