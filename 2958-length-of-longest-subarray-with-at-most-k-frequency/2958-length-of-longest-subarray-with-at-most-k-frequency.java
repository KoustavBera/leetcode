class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int curLen = 0, maxLen = 0;
        int l=0, r=0;
        while(r<nums.length){
            hmap.put(nums[r], hmap.getOrDefault(nums[r], 0)+1);
            while(hmap.get(nums[r])>k){
                hmap.put(nums[l],  hmap.getOrDefault(nums[l], 0)-1);
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}