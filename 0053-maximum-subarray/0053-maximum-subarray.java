class Solution {
    public int maxSubArray(int[] nums) {
        int curSum= 0, maxSum = nums[0];
        int n =nums.length;
        for(int i=0; i<n; i++){
            curSum += nums[i];
            maxSum = Math.max(maxSum, curSum);
            if(curSum<0){
                curSum=0;
            }
        }
        return maxSum;
    }
}