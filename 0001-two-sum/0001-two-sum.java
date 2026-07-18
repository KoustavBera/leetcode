class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            int dif = target - nums[i];
            if(map.containsKey(dif)) return new int[]{i, map.get(dif)};
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}