class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        // the basic logic is, suppose an array
        // [1 0 0 0 1 1 0 1]
        //  0 1 2 3 4 5 6 7
        // 0: -1, 1:0
        // in hashMap key sum = 0 value index -1
        // again in  index 7 sum = 0 that means form index (index(-1) +1) - 7 = sum is same 
        // as index 0, so we can say from 0 to index 7-> sum is 0 no change
        // in this way just we record the max distance through i - (j+1) +1 = i-j 

        hp.put(0, -1);
        int max = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0) sum = sum - 1;
            else sum = sum + 1;
            if(hp.containsKey(sum)){
                //if it previously contained the sum calculate the distance
                int prevIndex = hp.get(sum);
                max = Math.max(max, i-prevIndex);
            }
            else{
                //if not put it in the hashMap
                hp.put(sum, i);
            }
        } 
        return max;
    }
}