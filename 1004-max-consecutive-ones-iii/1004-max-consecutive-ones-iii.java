class Solution {
    public int longestOnes(int[] nums, int k) {
        //sliding window
        int l = 0, r = 0, n = nums.length, zeroes = 0, max = 0;
        while(r<n){
            if(nums[r]==0) zeroes++;

            while(zeroes > k){
                if(nums[l]==0)
                zeroes--;
                l++;
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}