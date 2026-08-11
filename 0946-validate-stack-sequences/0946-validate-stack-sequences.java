import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();

        int j = 0; // Pointer for popped

        for (int value : pushed) {

            // Push
            stack.push(value);

            // Pop whenever possible
            while (!stack.isEmpty()
                    && stack.peek() == popped[j]) {

                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}