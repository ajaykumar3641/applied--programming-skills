import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {

        // Stores indices in decreasing order of values
        Deque<Integer> maxDeque = new ArrayDeque<>();

        // Stores indices in increasing order of values
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        int answer = 0;

        for (int right = 0; right < nums.length; right++) {

            // Maintain decreasing order for maximum
            while (!maxDeque.isEmpty()
                    && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // Maintain increasing order for minimum
            while (!minDeque.isEmpty()
                    && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // If window is invalid, move left
            while (nums[maxDeque.peekFirst()]
                    - nums[minDeque.peekFirst()] > limit) {

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            // Current window is valid
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}

