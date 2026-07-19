class Solution {
    private static void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void nextPermutation(int[] nums) {
        int n= nums.length;
        int flag = 0, pivot = 1;
        //goal -   1 2 3 4(p) 5 3 1
        //output - 1 2 3 5 1 3 4
        // first find the pivot, the one which is >left but <right
        for(int i=n-1; i>0; i--){
            if(nums[i-1] < nums[i]){
                pivot = i-1;
                flag = 1;
                break;
            }
        }
        if(flag==1){
        // 1 -> 1 2 3 (4 5) 3 1
        // 2 -> 1 2 3 (5 4) 3 
        int swapIndex= n-1;
        while(nums[swapIndex]<=nums[pivot]){
            swapIndex--;
        }
        //1 2 3 4(p) 5(s) 3 1
        swap(nums, swapIndex, pivot);
        //here -> 1 2 3 (5p 4s) 3 1
        // now reverse 1 2 3 5 (4 3 1) ->  1 2 3 5 (1 3 4) so what are we doing? reversing from n-1 till swap-index
        int left = pivot+1, right = n-1;
        while(left<right){
            swap(nums, left, right);
            right--;
            left++;
        }
        }
        //if flag==0, it means we are at the last permutation and we need to simply reverse
        // 3 2 1
        // 1 2 3
        
        if(flag==0){
            int left = 0, right = n-1;
            while(left<right){
            swap(nums, left, right);
            right--;
            left++;
        }
        }

        return ;
    }
}