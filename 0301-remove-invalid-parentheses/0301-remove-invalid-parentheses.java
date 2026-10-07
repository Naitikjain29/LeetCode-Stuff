import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean foundValidAtCurrentLevel = false;

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            if (isValid(curr)) {
                result.add(curr);
                // Mark that we found a valid string at this removal depth level.
                // We will continue processing remaining strings in the queue at this level,
                // but won't generate any shorter strings for the next level.
                foundValidAtCurrentLevel = true;
            }

            // If we already found valid string(s) at the current minimum removal level,
            // do not generate smaller substrings.
            if (foundValidAtCurrentLevel) continue;

            // Generate all possible states by removing one parenthesis at a time
            for (int i = 0; i < curr.length(); i++) {
                char ch = curr.charAt(i);
                if (ch != '(' && ch != ')') continue; // Skip non-parenthesis characters

                String nextState = curr.substring(0, i) + curr.substring(i + 1);
                if (!visited.contains(nextState)) {
                    visited.add(nextState);
                    queue.add(nextState);
                }
            }
        }

        return result;
    }

    // Helper function to check if a string of parentheses is valid
    private boolean isValid(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
                if (count < 0) return false; // More closing than opening brackets
            }
        }
        return count == 0;
    }
}