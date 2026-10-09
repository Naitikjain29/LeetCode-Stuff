
class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                // If next character is also ')',
                // consume both closing brackets
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    // One ')' is missing
                    insertions++;
                }

                if (open > 0) {
                    open--;
                } else {
                    // Missing opening bracket
                    insertions++;
                }
            }
        }

        return insertions + 2 * open;
    }
}
