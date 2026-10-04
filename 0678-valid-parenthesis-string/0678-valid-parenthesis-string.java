class Solution {
    public boolean checkValidString(String s) {
        int cmin = 0; // Minimum possible open parentheses
        int cmax = 0; // Maximum possible open parentheses

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                cmin++;
                cmax++;
            } else if (ch == ')') {
                cmin--;
                cmax--;
            } else if (ch == '*') {
                cmin--; // If '*' acts as ')', open count decreases
                cmax++; // If '*' acts as '(', open count increases
            }

            // If max possible open parentheses drops below 0, there are too many ')'
            if (cmax < 0) {
                return false;
            }

            // cmin cannot be less than 0 (we cannot have a negative count of open brackets)
            if (cmin < 0) {
                cmin = 0;
            }
        }

        // If 0 is within our possible range of open brackets, the string is valid
        return cmin == 0;
    }
}
