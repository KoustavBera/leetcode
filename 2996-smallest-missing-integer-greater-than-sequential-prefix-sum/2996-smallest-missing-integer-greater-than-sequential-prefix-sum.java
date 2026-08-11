class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int prefix = nums[0], curLen = 1, maxLen = 0, max = nums[0];
        if(n>1){
        for(int i=1; i<n; i++){
            if(nums[i] == nums[i-1]+1) prefix += nums[i];
            else break;
        }        
        // Step 2: Store all numbers for O(1) lookup.
        Set<Integer> seen = new HashSet<>();
        for(int num : nums) seen.add(num);
        // Step 3: Starting from sum, find the first missing integer.
        int answer = prefix;
        while (seen.contains(answer)) {
            answer++;
        }
        return answer;
        }
     return max+1;
        
    }
}