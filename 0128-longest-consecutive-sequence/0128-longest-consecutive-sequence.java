class Solution {
    public int longestConsecutive(int[] nums) {
        // Optimal Solution HashSet
        Set<Integer> s = new HashSet<>();
        for(int num : nums) s.add(num); // lets take s = [100, 4, 200, 1, 3, 2]

        //now we have the power of contains
        //idea from now is to start from i and check if nums[i]-1 exist
        //if exist length++, track the max, else exit loop try again
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return 1;
        int maxL = 0;
        for(int num : s){
            //check if nums[i]-1 exist
            int j=1;
            if(!s.contains(num-1))
            {
                //if s does not contain num-1, num is the beginning of seq, 
                //[100,4,200,1,3,2] suppose 100, checks presence of 99 -> No -> 100 is
                //the start of seq, proceeds to check 101, 102 but no so skips 100 entirely
                //for this question this will again start from 100 4 200 [1] 3 2 -> runs O(N)
                int curr = num;
                //default length of all seq = 1
                int length = 1;
                while(s.contains(curr+1)){
                    length++;
                    curr++;
                }
                //after seq ends, checks if this seq length is the curr Max
                maxL = Math.max(maxL, length);
            }
        }
        
        return maxL;
    }
}