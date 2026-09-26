class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> hmap = new HashMap<>();
        for(int i=0; i<knowledge.size(); i++){
            hmap.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }
        String ans = "";
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            String tmp = "";
            if(c=='('){
                int j = i + 1; 
                while (s.charAt(j) != ')') {
                    tmp += s.charAt(j);
                    j++;
                }

                i = j; // move i to ')'
                if(hmap.containsKey(tmp)){
                    ans += hmap.get(tmp);
                }else{
                    ans += "?";
                    tmp += "";
                }
            }
            else
                ans += c;
           
        }
        return ans;
    }
}


/* 
Time and space complexity

1st hmap creation -> depends on length of knowledge -> O(K)
although we have an loop inside another loop each character is
processed only once there fore the TC O(N)

there fore: The TC O(K+N)
and space complexity O(K)(for hmap)

*/