class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack();
        int count=0;
        int ans =0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                st.pop();
                count--;
            }
            else if(ch == '('){
                st.push(ch);
                count++;
            }

            ans = Math.max(ans , count);
        }
        return ans;
    }
}