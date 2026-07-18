class Solution {
    public void sortColors(int[] nums) {
        int z=0, o=0,t=0;
        for(int i : nums){
            if(i==0) z++;
            if(i==1) o++;
            if(i==2) t++;
        }
        int k= 0 ;
        for(int i=0; i<z; i++) nums[k++] = 0;
        for(int i=0; i<o; i++) nums[k++] = 1;
        for(int i=0; i<t; i++) nums[k++] = 2;
    }
}