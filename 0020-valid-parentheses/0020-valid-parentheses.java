class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Opening brackets
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            }

            // Closing bracket )
            if (ch == ')') {
                if (st.isEmpty() || st.peek() != '(') {
                    return false;
                }
                st.pop();
            }

            // Closing bracket ]
            if (ch == ']') {
                if (st.isEmpty() || st.peek() != '[') {
                    return false;
                }
                st.pop();
            }

            // Closing bracket }
            if (ch == '}') {
                if (st.isEmpty() || st.peek() != '{') {
                    return false;
                }
                st.pop();
            }
        }

        return st.isEmpty();
    }
}