class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        int i = 0;
        for(int num : nums){
            if(hp.containsKey(target - num)){
                return new int[]{i, hp.get(target - num)};
            }
            hp.put(num, i++);
        }
        return new int[]{-1, -1};
    }
}