class Solution {
    public int findTargetSumWays(int[] nums, int target) {
    //diff expressions evaluates to target
    //eg : 3 1 1 2 target = 3
    // Possibility 1: +3 +2 -1 -1 Possibility 2: +3 +1 +1 -2
    // Rearranging +[3 2] - +[1 1]
    // We are diving array [3 2 1 1] into two subsets such that
    // diff betweem their sum = target
    // S1 + S2 = total
    // S1 - S2 = target
    // 2S1 = total + target -> S1 = (total + target)/2
    // so the question becomes how many subsets = (total + target)/2
    // count them =   the number of different expressions that you can build, which evaluates to target.
    int total = Arrays.stream(nums).sum();
    int req = (total + target)/2;
    if(total<Math.abs(target)) return 0;
    if((total+target)%2 != 0) return 0;
    int[][]dp = new int[nums.length][req+1];
    for(int[] row:dp)
    Arrays.fill(row, -1);
    return f(nums, nums.length-1, req, dp);
  }
  int f(int[]arr, int idx, int target, int[][] dp){
    if(idx == 0){
        //base case
        // 0-case
        //[0,0]
        //+0 -0/ -0 +0 //2
        if(target==0 && arr[0]==0) return 2; // take 0 or not take 0 both valid
        if(target==0 || arr[0]==target) return 1; //if target 0 not take // if 1 element and arr[0] == target take it 1 way
        //suppose we are at idx 0 and arr[0] != target no ways
        return 0;
    }
    if(dp[idx][target]!=-1) return dp[idx][target];
    //explore all possibilities
    int notTake = f(arr, idx-1, target, dp);
    int take = 0;
    if(arr[idx]<=target)
    take = f(arr, idx-1, target - arr[idx], dp);
    return dp[idx][target]= take+notTake;

  }
}