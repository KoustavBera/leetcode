class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        Realise:
        [1,2,3,4]
        left = [1, 1, 2, 6]
        right = [24,12,4,1]
        ans[i] = left[i] * right[i]
        */
        int n = nums.length;

        //easy version 

        // int[]pref = new int[n];
        // int []suf = new int[n];

        // pref[0] = 1;
        // suf[n-1] = 1; 
        // for(int i=1; i<n; i++){
        //     pref[i] = pref[i-1] * nums[i-1];
        // }
        // for(int i=n-2; i>=0; i--){
        //     suf[i] = suf[i+1] * nums[i+1];
        // }
        // for(int i=0; i<n; i++){
        //     nums[i] = pref[i]*suf[i];
        // }
        // return nums;

        // space optimised
        int left[] = new int[n];
        left[0] = 1;
        for(int i=1; i<n; i++){
            left[i] = left[i-1]*nums[i-1];
        }
        int rightProduct =1;
        int ans[] = new int[n];
        for(int i=n-1; i>=0; i--){
            ans[i] = left[i] * rightProduct;
            rightProduct *= nums[i]; 
        }
        return ans;
    }
}