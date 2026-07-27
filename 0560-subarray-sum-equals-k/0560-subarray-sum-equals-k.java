class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        //the logic is simple
        //take array 1 2 3
        //cumul. sum 1 3 6
        // suppose 1 2 3 4 5
        //         |--------| sum = 15
        //         |---| sum = 6
        //             |====| sum must be 15-6=9
        // that is what we are doing
        //we are storing cumulative sums
        // and then checking sum-k, if sum-k appeared in cumulative sum prev, that means from that index to curr index sum must be K
        //we are then doing count++;
        int count = 0, sum = 0;
        hmap.put(0, 1);
        for(int i=0 ; i<nums.length; i++){
            sum += nums[i];
            if(hmap.containsKey(sum - k)){
                //cotains k so count++ (occurence of target sum K ++)
                count += hmap.get(sum - k);
            }
            //else just put it in the hmap
            // for new cumul. sum encounters
            hmap.put(sum, hmap.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}