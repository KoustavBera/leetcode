class Solution {

    public boolean canPartition(int[] nums) {

        // Calculate the total sum of all elements
        int target = 0;
        for (int num : nums) {
            target += num;
        }

        // If the total sum is odd,
        // it is impossible to divide it into two equal subsets.
        if ((target & 1) == 1)
            return false;

        // We only need to find a subset whose sum is half of the total.
        target = target / 2;

        // Memoization table
        // dp[idx][target] stores whether it is possible to make 'target'
        // using elements from index 0 to idx.
        Boolean[][] dp = new Boolean[nums.length][target + 1];

        // Start recursion from the last index.
        return f(nums, nums.length - 1, target, dp);
    }

    boolean f(int[] nums, int idx, int target, Boolean[][] dp) {

        // Base Case 1:
        // If target becomes 0, we have successfully formed the required subset.
        if (target == 0)
            return true;

        // Base Case 2:
        // Only one element left.
        // We can form the target only if that element equals the target.
        if (idx == 0)
            return nums[0] == target;

        // If this state has already been computed,
        // return the stored answer.
        if (dp[idx][target] != null)
            return dp[idx][target];

        // -------------------------
        // Choice 1: Do NOT include the current element.
        // Move to the previous index while keeping the same target.
        // -------------------------
        boolean keep_in_subset = f(nums, idx - 1, target, dp);

        // -------------------------
        // Choice 2: Include the current element
        // (only if it does not exceed the remaining target).
        // -------------------------
        boolean not_keep = false;

        if (nums[idx] <= target) {
            not_keep = f(nums, idx - 1, target - nums[idx], dp);
        }

        // Store and return the result.
        // If either choice succeeds, answer is true.
        return dp[idx][target] = not_keep || keep_in_subset;
    }
}