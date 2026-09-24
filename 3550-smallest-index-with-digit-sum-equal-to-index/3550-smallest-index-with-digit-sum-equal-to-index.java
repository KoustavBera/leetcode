class Solution {
    public int smallestIndex(int[] nums) {
        int index = 0;
        for(int num : nums){
            int sumOfDigit = sum(num);
            if(sumOfDigit == index){
                return index;
            }
            index++;
        }
        return -1; 
    }
    int sum(int num){
        int s = 0;
        while(num >0){
            s += num % 10;
            num /= 10;
        }
        return s;
    }
}