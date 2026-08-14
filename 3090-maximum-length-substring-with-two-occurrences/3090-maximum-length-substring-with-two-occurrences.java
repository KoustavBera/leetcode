class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int n = s.length(), curlen = 0 , maxLen = 0, l = 0, r  = 0;

        while(r < n){
            char cur = s.charAt(r);
            freq.put(cur, freq.getOrDefault(cur, 0) + 1);
            while(freq.get(cur) > 2){
                char left = s.charAt(l);
                freq.put(left, freq.get(left) - 1);
                l++;
            }
            maxLen = Math.max(maxLen,  r - l + 1);
            r++; 
        }
        return maxLen;
    }
}