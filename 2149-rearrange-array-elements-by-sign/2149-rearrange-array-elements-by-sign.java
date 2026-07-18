class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        // Brute force TC: O(n) + O(n/2) SC: O(n)
        // int[] pos = new int[n];
        // int[] neg = new int[n];
        // int p=0, s=0;
        // for(int i=0; i<n; i++){
        //     if(nums[i]>=0) pos[p++] = nums[i];
        //     else neg[s++]=nums[i];
        // }
        // int[] ans = new int[n];
        // for(int i=0; i<n/2; i++){
        //     ans[2*i] = pos[i];
        //     ans[2*i+1] = neg[i];
        // }
        // return ans;

        // To interviewe -> can you optimise further? 
        //May be in one pass:
        int posP = 0;
        int negP = 1;
        int i=0;
        int[] ans = new int[n];

        while(i < n){
            if(nums[i]<0) {
                //neg
                ans[negP] = nums[i];
                negP+=2;
            }
            else{
                //pos
                ans[posP] = nums[i];
                posP +=2;
            }
            i++;
        }
        return ans;
    }
}