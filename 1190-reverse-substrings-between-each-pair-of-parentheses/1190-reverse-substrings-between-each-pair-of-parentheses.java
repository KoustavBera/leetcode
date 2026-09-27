class Solution {
    public String reverseParentheses(String s) {

        int n = s.length();

        // pair[i] = index of the matching parenthesis
        int[] pair = new int[n];

        Stack<Integer> st = new Stack<>();

        // Step 1: Find matching parentheses
        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '(') {
                st.push(i);
            }

            else if (s.charAt(i) == ')') {
                int open = st.pop();

                pair[i] = open;
                pair[open] = i;
            }
        }

        // Step 2: Traverse the string
        StringBuilder ans = new StringBuilder();

        int i = 0;
        int direction = 1;

        while (i < n) {

            char c = s.charAt(i);

            if (c == '(' || c == ')') {

                // Jump to matching bracket
                i = pair[i];

                // Reverse direction
                direction = -direction;

            } else {

                ans.append(c);
            }

            i += direction;
        }

        return ans.toString();
    }
}