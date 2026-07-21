class Solution {
    public int firstUniqChar(String s) {
        int lnr = Integer.MAX_VALUE;
        int count[] = new int[26];
        int v = 0;
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            count[curr-'a']++;
        }
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(count[curr-'a']==1){
                return i;
            }
        }
        return -1;
    }
}