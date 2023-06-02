import java.util.*;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length - 1];
        int[] memo = new int[maxDay + 1 + 30];

        for(int i = 0; i < days.length; ++i) {
            var day = days[i];

            var use1DayTicket = memo[day - 1 + 30] + costs[0];
            var use7DayTicket = memo[day - 7 + 30] + costs[1];
            var use30DayTicket = memo[day - 30 + 30] + costs[2];

            var profitableTicket = Math.min(use1DayTicket, Math.min(use7DayTicket, use30DayTicket));
            memo[day + 30] = profitableTicket;

            if (i < days.length - 1) {
                for (int j = day + 1; j < days[i + 1]; ++j) {
                    memo[j + 30] = profitableTicket;
                }
            }
        }

        return memo[maxDay + 30];
    }

/**
 private int findMin(int[] days, int[] costs, int idx, int expirationDayOfTicket) {
 if(idx < 0) {
 return 0;
 }

 var day = days[idx];

 if (day > expirationDayOfTicket) {
 return findMin(days, costs, idx - 1, expirationDayOfTicket);
 }

 var use1DayTicket = findMin(days, costs, idx - 1, day - 1) + costs[0];
 var use7DayTicket = findMin(days, costs, idx - 1, day - 7) + costs[1];
 var use30DayTicket = findMin(days, costs, idx - 1, day - 30) + costs[2];

 return Math.min(use1DayTicket, Math.min(use7DayTicket, use30DayTicket));
 }
 **/
}