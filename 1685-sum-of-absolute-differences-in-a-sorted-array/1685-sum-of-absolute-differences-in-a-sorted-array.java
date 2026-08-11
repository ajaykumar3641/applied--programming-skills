class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Total sum of all elements
        long totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        long leftSum = 0;

        for (int i = 0; i < n; i++) {
            long x = nums[i];

            // Sum of differences with elements on the left
            long left = x * i - leftSum;

            // Sum of elements on the right
            long rightSum = totalSum - leftSum - x;

            // Sum of differences with elements on the right
            long right = rightSum - x * (n - i - 1);

            result[i] = (int) (left + right);

            // Add current element for the next iteration
            leftSum += x;
        }

        return result;
    }
}