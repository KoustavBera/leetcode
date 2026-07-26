class Solution {
    public int maximumProduct(int[] nums) {
        if(nums.length <=3){
            int mul = 1;
            for(int num: nums) mul*= num;
            return mul;
        }
        else{
            //{1,2,-3,4} -> 8, 
            //{-1,-2,-3,-4} ->-6,
            //{-6,-2,4,-2} -> 48
            int n = nums.length;
            int max1=Integer.MIN_VALUE, max2=Integer.MIN_VALUE, max3=Integer.MIN_VALUE;
            int min1 = Integer.MAX_VALUE, min2=Integer.MAX_VALUE;

            //find the values
            for(int i=0; i<n; i++){
                if(nums[i]>=max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
                }else if(nums[i]>=max2){
                max3 = max2;
                max2 =  nums[i];
                }else if(nums[i]>=max3){
                    max3 = nums[i];
                }
                if(nums[i]<=min1){
                    min2=min1;
                    min1 = nums[i];
                }else if(nums[i]<=min2){
                    min2 = nums[i];
                }
        
            }
 
                return Math.max(min1*min2*max1, max1*max2*max3);


        }
    }
}