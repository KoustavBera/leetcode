class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        boolean[] vis = new boolean[26];
        int count[] = new int[26];
        for(char c: s.toCharArray()){
            count[c - 'a']++;
        }
        if(s.length()==0) return "";
        for(char c : s.toCharArray()){
            //decrement c as we progress
            count[c - 'a']--;
            if(vis[c-'a']) continue;
            while(!st.isEmpty() && c < st.peek() && count[st.peek() - 'a']>0){
                vis[st.peek()-'a'] = false;
                st.pop();
            }
            st.push(c);
            vis[c-'a'] = true;
        }
        
        StringBuilder str = new StringBuilder();
        for(char c : st) str.append(c);
        return str.toString();
    }
}