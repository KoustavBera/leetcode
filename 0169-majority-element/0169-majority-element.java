class Solution {
    public int majorityElement(int[] nums) {
        //Brute
        // for each number
        //     count occurrences(O(n^2))

        //Better
        // use HashMap (O^n)

        //Optimal (Boyer-Moore Voting)
        int count = 0;
        int candidate = 0;
        for(int num: nums){
            if(count == 0) candidate = num;
            count += (candidate == num )? 1 : -1;
        }
        return candidate;
    }
}