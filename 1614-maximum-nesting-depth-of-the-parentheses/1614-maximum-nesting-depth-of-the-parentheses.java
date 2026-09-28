class Solution {
    public int maxDepth(String s) {
            int count = 0, mx = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                count++;
                mx = Math.max(mx, count);
            }
            if(c == ')'){
                count--;
            }
        }
        return mx;
    }
}