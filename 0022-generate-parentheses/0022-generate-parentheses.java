class Solution {
    List<String> ans;
    int n;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        this.n = n;
        f(new StringBuilder(), 0, 0);
        return ans;
    }
    void f(StringBuilder current, int open, int close){
        // if(open == n && close == n){
        //     ans.add(current);
        // }
        // if(open < n){
        //     f(current + '(', open + 1, close);
        // }
        // if(close < open) {
        //     f(current + ')', open, close + 1);
        // }

        //More optimised version:
        if(open == n && close == n){
            ans.add(current.toString());
            return;
        }
        if(open < n){
            current.append('(');
            f(current, open + 1, close);
            current.deleteCharAt(current.length()-1);
        }
        if(close < open) {
            current.append(')');
            f(current, open, close+1);
            current.deleteCharAt(current.length()-1);
        }

    }
}