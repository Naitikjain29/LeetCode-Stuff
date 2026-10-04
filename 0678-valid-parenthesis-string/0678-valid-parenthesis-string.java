import java.util.Stack;

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        // Step 1: Process the string from left to right
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                leftStack.push(i);
            } else if (ch == '*') {
                starStack.push(i);
            } else { // ch == ')'
                // Try to balance ')' with a '(' first
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } 
                // If no '(', try to balance ')' with a '*'
                else if (!starStack.isEmpty()) {
                    starStack.pop();
                } 
                // If neither is available, the string is invalid
                else {
                    return false;
                }
            }
        }

        // Step 2: Match remaining '(' with remaining '*'
        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            // If the '(' appears AFTER the '*', the '*' cannot close it (e.g., "*( ")
            if (leftStack.peek() > starStack.peek()) {
                return false;
            }
            leftStack.pop();
            starStack.pop();
        }

        // If all left parentheses are balanced, the string is valid
        return leftStack.isEmpty();
    }
}
