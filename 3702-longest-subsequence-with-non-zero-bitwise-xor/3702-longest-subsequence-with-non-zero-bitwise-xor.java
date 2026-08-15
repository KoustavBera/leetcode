class Solution {
    public int longestSubsequence(int[] nums) {
        boolean hasNonZero = false;
        int TOTAL_XOR = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] != 0) hasNonZero = true;
            TOTAL_XOR ^= nums[i];
        }

        if(TOTAL_XOR == 0){
            if(!hasNonZero){
                return 0;
            }
            else{
                return n-1; // if xor is 0, and it has non Zero, then removing one element will make the xor non zero again
                //take {1 1 0} -> total xor = 0 but removing one element out of 1 and 1 will make the total xor 1.
            }
        }
        else{
            return n;
        }
    }
}