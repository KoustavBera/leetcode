class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        int balance = 0;
        for(char c : s.toCharArray())
        {
            if(c == '('){
                if(balance > 0){
                    str.append(c);
                }
                balance++;
            }
            else{
                balance--;
                if(balance > 0){
                    str.append(c);
                }
            }
        }
        return str.toString();
    }
}