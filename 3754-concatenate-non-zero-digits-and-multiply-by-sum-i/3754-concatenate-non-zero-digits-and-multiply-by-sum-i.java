class Solution {
    public long sumAndMultiply(int n) {
        long ans=0;
        int pow=0;
        while(n>0){
            long rem = n%10;
            ans = rem*(int)Math.pow(10, pow)+ans;
            n=n/10;
            if(rem!=0)
            pow++;
        }
        long sum= 0;
        long b = ans;
        while(ans>0){
            long rem = ans%10;
            sum+=rem;
            ans/=10;
        }

        return b*sum;
    }
}