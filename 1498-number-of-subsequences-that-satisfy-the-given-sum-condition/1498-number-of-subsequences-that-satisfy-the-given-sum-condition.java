class Solution {
    public int numSubseq(int[] nums, int target) {
        int MOD = 1_000_000_007;
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        long ans = 0;
        long[] pow = new long[n];
        pow[0] = 1;
        for(int i=1; i<n; i++){
            pow[i] = (pow[i-1]*2L)%MOD;
        }

        while(left <= right){
            if(nums[left] + nums[right] <= target){
                //count all subsequence
                ans =( ans + pow[right-left])% MOD;
                left++;
            }
            else{
                right--;
            }
        }
        return (int)ans;

    }
}