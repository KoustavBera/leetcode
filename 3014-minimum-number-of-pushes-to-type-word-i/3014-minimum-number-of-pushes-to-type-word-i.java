class Solution {
    public int minimumPushes(String word) {
       int length = word.length();
       if(length<=8) return length;
       if(length>8 && length <=16) return length+(length-8);
       if(length>16 && length <=24) return length+8+(length-16)+(length-16);
       return length+8+8+8+(length-24)+(length-24)+(length-24);
    }
}