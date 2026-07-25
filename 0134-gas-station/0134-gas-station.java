class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      int totalTank = 0;
        int currentTank = 0;
        int startStation = 0;
        
        for (int i = 0; i < gas.length; i++) {
            // 1. Calculate the net gas at station i
            int netGas  = gas[i] - cost[i];
            // 2. Add it to totalTank and currentTank
            currentTank += netGas;
            totalTank += netGas;
            // 3. If currentTank drops below 0, what do we do? (Think about your pointers and res
            if(currentTank < 0){
                currentTank = 0;
                startStation = i+1;
            }
        }
        return (totalTank<0)?-1:startStation;
        
        // 4. Check the global condition at the end
        
        // 5. Return the answer
    }
}