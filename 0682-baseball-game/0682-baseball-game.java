import java.util.*;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for (String op : operations) {

            if (op.equals("+")) {
                int top = st.pop();
                int secondTop = st.peek();
                int sum = top + secondTop;

                st.push(top);   // restore
                st.push(sum);   // push new score

            } else if (op.equals("C")) {
                st.pop();

            } else if (op.equals("D")) {
                st.push(st.peek() * 2);

            } else {
                // number case
                st.push(Integer.parseInt(op));
            }
        }

        int ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }
}