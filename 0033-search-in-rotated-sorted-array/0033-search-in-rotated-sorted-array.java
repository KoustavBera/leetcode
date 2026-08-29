class Solution {
    public int search(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int mid = (l+r)/2;

            if(nums[mid] == target){
                return mid;
            }
// 4 5 6 7 0 1 2
// mid = 7 and 4 < 7 so its guaranteed sorted
            else if(nums[l] <= nums[mid]){
                if(nums[l]<= target && target <= nums[mid]){
                    r = mid - 1;
                }
                else{
                    l = mid+1;
                }
            }
            else{
                //nums[l] > nums[mid] -> so search in right sorted
                if(nums[mid] <= target && target <= nums[r]){
                    l = mid+1;
                }
                else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}