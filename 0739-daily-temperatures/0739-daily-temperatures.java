import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] answer = new int[n];

        // Store indices, not temperatures
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Current temperature is warmer
            // than the temperature at stack.peek()
            while (!stack.isEmpty()
                    && temperatures[i] > temperatures[stack.peek()]) {

                int previousDay = stack.pop();

                // Calculate number of days to wait
                answer[previousDay] = i - previousDay;
            }

            // Store current day's index
            stack.push(i);
        }

        return answer;
    }
}