class Solution {
    public int removeDuplicates(int[] nums) {
        int k=2;
        int n=nums.length;
        for(int i=2; i<n;i++){
            // compare current number with -2 number -> same(so curr is 3rd) diff(curr is allowed)
            if(nums[k-2]!=nums[i]){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}
    
