class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        var totalGas = 0;
        var totalCost = 0;
        for (int i = 0; i < gas.length; ++i) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) {
            return -1;
        }

        var currentGas = 0;
        var startIdx = 0;
        for(int i = 0; i < gas.length; ++i) {
            currentGas += gas[i] - cost[i];
            if(currentGas < 0) {
                currentGas = 0;
                startIdx = i + 1;
            }
        }
        return startIdx;
    }
}