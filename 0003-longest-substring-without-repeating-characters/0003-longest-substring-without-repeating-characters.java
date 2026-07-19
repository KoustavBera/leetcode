class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int l = 0, r = 0 ;
        int n = s.length();
        int maxUntilNow = 0;
        int le = 0;
        if(s.length()==0) return 0;
        while(r < n){
            if(!seen.contains(s.charAt(r))){
                seen.add(s.charAt(r));
                maxUntilNow = Math.max(maxUntilNow, r-l+1);
                r++;
            }
            else{
                seen.remove(s.charAt(l));
                l++;
            }
        }
        return maxUntilNow;
    }
}