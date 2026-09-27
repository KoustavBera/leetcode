class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st1 = new Stack<>() ;
                                
// ( a b (c d) ) -> a  ( b ( c d )   ) ->  d c
                             // ^
String ans = "";
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                String tmp = "";
                while(st1.peek()!='(' && !st1.isEmpty()){
                    tmp += st1.pop();
                }
                if(!st1.isEmpty() && st1.peek() == '(')
                st1.pop();
                for(char t : tmp.toCharArray()){
                    st1.push(t);
                }
            }
            else
            st1.push(c);
        }
        while(!st1.isEmpty()){
            ans  = st1.pop() + ans;
        }
        return ans;
    }
}