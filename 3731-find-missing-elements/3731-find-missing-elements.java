class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max = nums[0], min = nums[0];
        for(int num : nums){
            min = (num <min) ? num : min;
            max = (num > max) ? num : max;
        }
        boolean[] present = new boolean[max+nums.length];
        List<Integer> list = new ArrayList<>();
        for(int num : nums) present[num] = true;
        for(int i=min; i<max; i++){
            if(!present[i]) list.add(i);
        }
        return list;
    }
}