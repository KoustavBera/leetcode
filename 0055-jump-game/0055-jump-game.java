class Solution {
    public boolean canJump(int[] nums) {
        // logic is fairly simple
        // at each index we cal the max reachable index from that index.
        // if at any point current index > what we assumed to be max reachable index
        // viola! return false;
        // else return true;
        int reachable = 0;
        for(int i=0; i< nums.length; i++){
            if(i > reachable) return false;
            reachable = Math.max(reachable, i+nums[i]);
        }
        return true;
    }
}