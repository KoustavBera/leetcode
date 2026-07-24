class Solution {
    public int uniqueXorTriplets(int[] nums) {
        //order of xor does not matter
        int n = nums.length;
        // 1. find max
        int max= 0;
        for(int num : nums){
            max = (max < num) ? num : max;
        }
        // 2. find max possible XOR value
        int limit = 1;
        while(limit<=max){
            limit<<=1;
        }

        //3. unique elements
        boolean[] present = new boolean[limit];
        int[] U = new int[n];
        int uSize = 0;
        for(int num : nums){
            if(!present[num]){
                present[num] = true;
                U[uSize++] = num;
            }
        }

        //4. compute a^b
        boolean[] com1 = new boolean[limit];
        for(int i=0; i<uSize; i++){
            for(int j=i; j<uSize; j++){
                int x = U[i]^U[j];
                com1[x] = true;
            }
        }

        //5. compute 3rd
                boolean[] com2 = new boolean[limit];
        for(int i=0; i<limit; i++){
            if(com1[i]){ //if true that means that index is the computed value
            for(int k = 0; k<uSize; k++){
                com2[i^U[k]] = true;
            }
            }
        }

        //now com2 contains final values as indexes
        //compute and count unique
        int count = 0; 
        for(int i=0 ;i<limit; i++){
            if(com2[i]){
                count++;
            }
        }
        return count; 


}
}