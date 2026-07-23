class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int len=nums.length;
        if(len <=2) return len;
        int bitcount = Integer.SIZE - Integer.numberOfLeadingZeros(len);
        return (int)Math.pow(2, bitcount);
    }
}