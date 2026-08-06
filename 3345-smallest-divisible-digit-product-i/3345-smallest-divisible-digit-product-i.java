class Solution {
    public int smallestNumber(int n, int t) {
        int stop = 1;
        while(stop != 0){
            int p = n;
            int prod = 1;
            while(p>0){
                prod *= p%10;
                p /= 10; 
            }
            if(prod % t == 0) return n;
            n++;
        }
        return 0;
    }
}