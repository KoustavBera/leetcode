class Solution {
    public int maxProduct(int n) {
        int max = 0, secondMax = 0;
        while(n>0){
            int rem  = n % 10;
            if(rem >= max){
                secondMax = max;
                max = rem;
            }
            else if(rem > secondMax ){
                secondMax = rem;
            }

            n = n/10;
        }
        return max*secondMax;
    }
}