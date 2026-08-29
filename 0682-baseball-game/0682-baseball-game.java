class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for (String op : operations) {

            if (op.equals("+")) {
                int top = st.pop();
                int secTop = st.peek();

                st.push(top);
                st.push(top + secTop);
            }

            else if (op.equals("C")) {
                st.pop();
            }

            else if (op.equals("D")) {
                st.push(st.peek() * 2);
            }

            else {
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