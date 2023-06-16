package com.saltuk.largest.number;

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {

        Integer[] boxedArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(boxedArray, (a, b) -> {
            String aStr = Integer.toString(a);
            String bStr = Integer.toString(b);

            String aFirst = aStr + bStr;
            String bFirst = bStr + aStr;

            for(int i = 0; i < aFirst.length(); ++i) {
                if(aFirst.charAt(i) > bFirst.charAt(i)) {
                    return -1;
                } else if(aFirst.charAt(i) < bFirst.charAt(i)) {
                    return 1;
                }
            }
            return 0;
        });

        if(boxedArray[0] == 0) {
            return "0";
        }

        var res = new StringBuilder();

        Arrays.stream(boxedArray).forEach(res::append);

        return res.toString();
    }
}
