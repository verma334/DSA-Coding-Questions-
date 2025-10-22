package ArrayAndStringsDSAQuestions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

	
	 public int[] maxSlidingWindow(int[] nums, int k) {
	        if (nums == null || k <= 0) return new int[0];

	        int n = nums.length;
	        int[] result = new int[n - k + 1];
	        Deque<Integer> deque = new ArrayDeque<>();

	        for (int i = 0; i < n; i++) {
	            // Remove indices outside the current window
	            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
	                deque.pollFirst();
	            }

	            // Remove indices whose values are less than nums[i]
	            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
	                deque.pollLast();
	            }

	            deque.offerLast(i);

	            // Add the max value to result once the first window is complete
	            if (i >= k - 1) {
	                result[i - k + 1] = nums[deque.peekFirst()];
	            }
	        }

	        return result;
	    }

	    // Example usage
	    public static void main(String[] args) {
	    	SlidingWindowMaximum swm = new SlidingWindowMaximum();
	        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
	        int k = 3;
	        System.out.println(Arrays.toString(swm.maxSlidingWindow(nums, k)));
	        // Output: [3, 3, 5, 5, 6, 7]
	    }

}
