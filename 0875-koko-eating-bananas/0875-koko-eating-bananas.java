class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;
        for(int pile : piles) max = (max < pile) ? pile : max;
        //now we need to find value of k... in range
        //[1 ..... max] that is the min integer that she can eat bananas with
        //in h hours 
        int minSpeed = max; //worst case
        while(min <= max){
            int mid = min + (max - min)/2;

            //now we have to check if mid can satisfy piles in h
            if(checkFinish(piles, mid, h)){
                //if it returns true then mid works
                //first update Min
                minSpeed = mid; 
                //lets try smaller value of mid
                max = mid-1;
            }
            else{
                //if returns false then mid is too slow, so need to eat faster
                min = mid + 1;
            }
        }
        return minSpeed;
    }
    boolean checkFinish(int[] piles, int mid, int h){
        int hoursNeeded = 0 ;
        for(int pile : piles){
            hoursNeeded += (pile - 1) / mid  + 1;
            if(hoursNeeded > h) return false;
        }
        return true;
    }
}