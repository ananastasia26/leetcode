package com.saltuk.merge.interval;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 56-merge-interval
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        var mergedIntervals = new ArrayList<int[]>();
        var intervalStart = intervals[0][0];
        var intervalEnd = intervals[0][1];

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for(int i = 0; i < intervals.length; ++i) {
            var currentStart = intervals[i][0];
            var currentEnd = intervals[i][1];

            if (currentStart > intervalEnd) {
                int[] newInterval = {intervalStart, intervalEnd};
                mergedIntervals.add(newInterval);
                intervalStart = currentStart;
                intervalEnd = currentEnd;
            } else if(currentEnd > intervalEnd) {
                intervalEnd = currentEnd;
            }

            if (i == intervals.length - 1) {
                int[] lastInterval = {intervalStart, intervalEnd};
                mergedIntervals.add(lastInterval);
            }
        }

        var result = new int[mergedIntervals.size()][2];
        mergedIntervals.toArray(result);
        return result;
    }
}