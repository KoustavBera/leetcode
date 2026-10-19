class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // Arrays.sort(nums);
        // ArrayList<Integer> ans = new ArrayList<>();
        // for(int i=0; i<nums.length; i++){
        //     if(nums[i]==target) ans.add(i);
        // }
        // return ans;


        // ** More optimised approach
        // logic is to do this without sorting
        // how? count number of elements < target
        // they will surely take up indices = countLessThanTarget
        // like if there is 1 element less than target it will take indice 0
        // then just add number of elements equal to the target
        ArrayList<Integer> ans = new ArrayList<>();
        int countLessThanTarget = 0;
        int countEqualToTarget = 0;
        for(int num : nums){
            if(num < target) countLessThanTarget++;
            else if(num == target) countEqualToTarget++;
        }
        for(int i=0; i<countEqualToTarget; i++){
            ans.add(countLessThanTarget + i);
        }
        return ans;
    }
}