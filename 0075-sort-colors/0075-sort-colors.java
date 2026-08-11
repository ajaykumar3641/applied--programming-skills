class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {
                // Put 0 at the beginning
                swap(nums, low, mid);
                low++;
                mid++;
            }

            else if (nums[mid] == 1) {
                // 1 is already in the correct middle section
                mid++;
            }

            else { // nums[mid] == 2
                // Put 2 at the end
                swap(nums, mid, high);
                high--;

                // Don't increment mid here
                // because the swapped element needs to be checked
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}