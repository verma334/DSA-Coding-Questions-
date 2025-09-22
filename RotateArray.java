package ArrayAndStringsDSAQuestions;

import java.util.Arrays;

public class RotateArray {

	  // Rotates the array to the right by k steps
    public void rotate(int[] nums, int k) {
        // Handle cases where k > length of array
        k = k % nums.length;

        // Step 1: Reverse the entire array
        reverse(nums, 0, nums.length - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
    }

    // Helper method to reverse elements in the array from index start to end
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // Swap elements at start and end
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            // Move pointers inward
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();

        // Input array and rotation count
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        // Call rotate method
        ra.rotate(nums, k);

        // Print the rotated array
        System.out.println("Rotated elements: " + Arrays.toString(nums));
        
    }

}
