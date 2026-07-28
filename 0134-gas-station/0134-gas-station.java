class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // logic is fairly simple
        // suppose station i has petrol 2 ltr now the next journey will require
        // petrol 4 ltr
        //so the question is is the journey possible? No ofcourse, so station ++;
        //subsequently we have to check even if we found a station is the whole
        // journey possible or not
        //for the whole jounrey to be possible summation(gas[i] - cost[i]) >=0
        //thats why in the mean time we also track total. if total <0, return  -1
        int current=0, total=0, station = 0;
        for(int i=0 ; i < gas.length; i++){
            //current is gas - journey
            current += gas[i] - cost[i];
            total += current;
            // if current < 0 , joruney not feasible update current to 0 and move to next station
            if(current<0){
                current = 0;
                station += 1;
            }
        }
        //at end check if total < 0 or not
        return (total < 0 )? -1 : station ;
    }
}