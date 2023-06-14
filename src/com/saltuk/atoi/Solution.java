package com.saltuk.atoi;

import java.util.ArrayList;

/**
 * 08-atoi
 */
public class Solution {
    private static final int MAX_VALUE = Integer.MAX_VALUE / 10;
    private static final int CORNER_DIGIT_MAX_VALUE = Integer.MAX_VALUE % 10;
    private static final int CORNER_DIGIT_MIN_VALUE = Math.abs(Integer.MIN_VALUE % 10);

    public int myAtoi(String s) {
        var currentState = State.START;
        var positive = true;
        var digits = new ArrayList<Character>();
        for (var i = 0; i < s.length(); ++i){
            var currentChar = s.charAt(i);
            if (Character.isLetter(currentChar)) {
                currentState = State.LETTER;
                break;
            } else if(currentChar == ' ') {
                if (currentState == State.START || currentState == State.WHITESPACE) {
                    currentState = State.WHITESPACE;
                }
                else {
                    break;
                }
            } else if (currentChar == '+' || currentChar == '-') {
                if (currentState == State.WHITESPACE || currentState == State.START) {
                    currentState = State.SIGN;
                    positive = currentChar == '+';
                } else {
                    break;
                }
            } else if (Character.isDigit(currentChar)) {
                currentState = State.DIGIT;
                digits.add(currentChar);
            } else {
                currentState = State.ANOTHER_CHAR;
                break;
            }
        }

        int number = 0;
        for(var digit : digits) {
            var n = Character.getNumericValue(digit);
            if(number > MAX_VALUE) {
                number = positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                break;
            } else if (number == MAX_VALUE) {
                if (positive && n > CORNER_DIGIT_MAX_VALUE) {
                    number = Integer.MAX_VALUE;
                    break;
                } else if (!positive && n > CORNER_DIGIT_MIN_VALUE){
                    number = Integer.MIN_VALUE;
                    break;
                }
            }

            number = 10 * number + n;
        }
        return number * (positive ? 1 : -1);
    }

    public static void main(String[] args) {
        var s = new Solution();
//        int i1 = s.myAtoi("");
//        int i2 = s.myAtoi("    -123");
//        int i3 = s.myAtoi("123 qwe");
//        int i4 = s.myAtoi("qwe123 qwe");
//        int i5 = s.myAtoi("444qwe");
//        int i6 = s.myAtoi("--12");
//        int i7 = s.myAtoi("-91283472332");
//        int i8 = s.myAtoi("3.14159");
//        int i9 = s.myAtoi("-3.14159");
        int i10 = s.myAtoi("2147483646");
        int i11 = s.myAtoi("2147483647");
        int i12 = s.myAtoi("2147483648");
        int i13 = s.myAtoi("-2147483646");
        int i14 = s.myAtoi("-2147483648");
        int i15 = s.myAtoi("-2147483649");

        System.out.println(i10 + " " + i11 + " " + i12 + " " + i13 + " " + i14 + " " + i15 + " ");
    }
}

enum State {
    START,
    WHITESPACE,
    SIGN,
    DIGIT,
    LETTER,
    ANOTHER_CHAR
}
