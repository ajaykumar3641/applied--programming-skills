import java.util.*;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // Opening bracket
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            // Closing bracket
            else {
                // No opening bracket available
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check matching pair
                if (c == ')' && top != '(') {
                    return false;
                }

                if (c == '}' && top != '{') {
                    return false;
                }

                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }

        // Valid only if all opening brackets were closed
        return stack.isEmpty();
    }
}