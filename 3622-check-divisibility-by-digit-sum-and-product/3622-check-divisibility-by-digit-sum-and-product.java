class Solution {
    public boolean checkDivisibility(int n) {
    int prod  = 1, sum = 0, num = n;
    while(num !=0){
        int rem = num %10;
        prod *= rem;
        sum += rem;
        num /= 10;
    }    
    return n % (prod + sum) == 0;
    }

}