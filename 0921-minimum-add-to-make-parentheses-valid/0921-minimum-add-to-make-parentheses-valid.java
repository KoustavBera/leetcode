class Solution {
    public int minAddToMakeValid(String s) {
        int balance = 0, answer = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == ')')
            balance--;
            else
            balance++;
            if(balance < 0){
                answer++;
                balance = 0;
            }
        }
        return balance + answer;
    }
}