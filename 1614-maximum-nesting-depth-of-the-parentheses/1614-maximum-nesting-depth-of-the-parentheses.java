class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
            int count = 0, mx = 0;
        for(char c : s.toCharArray()){
            if(st.isEmpty()){
                count = 0;
            }
            if(c=='('){
                st.push(c);
                count++;
            }
            if(!st.isEmpty() && st.peek() == '(' && c == ')'){
                st.pop();
                count--;
            }
            mx = Math.max(mx, count);

        }
        return mx;
    }
}