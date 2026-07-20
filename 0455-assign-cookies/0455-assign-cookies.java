class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l=0, r=0;
        int count = 0;
        while(l<g.length && r<s.length){
            if(g[l]<=s[r]){ //greed <= size
                count++; //increase count
                l++;
            }
            
            r+=1; //satisfied or not move to next cookie
        }
        return count;
    }
}