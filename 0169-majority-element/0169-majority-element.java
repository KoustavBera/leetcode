class Solution {
    public int majorityElement(int[] nums) {
        int n= nums.length;
        int thres =(n/2);
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);
        }
        for(int i:nums){
            int val = mp.get(i);
            if(val > thres){
                return i;
            }
        }
        return -1;
    }
}