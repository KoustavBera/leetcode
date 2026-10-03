class Solution {
    public int longestValidParentheses(String s) {
        int l = 0, r = 0, currLen = 0, maxLen = 0, open = 0, close = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') open++;
            if(c == ')') close++;
            if(close > open){
                open = 0;
                close = 0;
            }
            if(close == open){
                maxLen = Math.max(maxLen, open + close);
            }
        }
        open = 0; close = 0;
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(c == ')') close++;
            if(c == '(') open++;
            if(close < open){
                open = 0;
                close = 0;
            }
            if(close == open){
                maxLen = Math.max(maxLen, open + close);
            }
        }
        return maxLen;
    }
    /**
    (()
    open  = 1 2
    close = 0 1
     */
}