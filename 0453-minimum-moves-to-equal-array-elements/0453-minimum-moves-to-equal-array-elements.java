class Solution {
    public int minMoves(int[] nums) {
        // Step 1: Find the minimum element in the array
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        
        // Step 2: Calculate the sum of differences from the minimum
        int moves = 0;
        for (int num : nums) {
            moves += (num - min);
        }
        
        return moves;
    }
}