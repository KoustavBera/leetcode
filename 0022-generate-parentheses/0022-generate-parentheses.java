class Solution {
    List<String> ans;
    int n;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        this.n = n;
        f("", 0, 0);
        return ans;
    }
    void f(String current, int open, int close){
        if(open == n && close == n){
            ans.add(current);
        }
        if(open < n){
            f(current + '(', open + 1, close);
        }
        if(close < open) {
            f(current + ')', open, close + 1);
        }
    }
}