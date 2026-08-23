class Solution {
    private void swap(int[]nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    public void moveZeroes(int[] nums) {
        int lastZeroIndex = 0;
        int n = nums.length;
        for(int i=0; i < n; i++){
            if(nums[i]!=0){
                swap(nums, i, lastZeroIndex);
                lastZeroIndex++;
            }
        }
    }
}