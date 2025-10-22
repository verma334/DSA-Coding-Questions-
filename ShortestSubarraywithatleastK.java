package ArrayAndStringsDSAQuestions;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarraywithatleastK {

	public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        
    
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minLength = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < prefixSum.length; i++) {
            // Check if current prefix sum - oldest in deque >= k
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            // Maintain increasing order in deque
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return minLength <= n ? minLength : -1;
    }
	public static void main(String[] args) {
		ShortestSubarraywithatleastK solver = new ShortestSubarraywithatleastK();
        System.out.println(solver.shortestSubarray(new int[]{1}, 1));         // Output: 1
        System.out.println(solver.shortestSubarray(new int[]{1, 2}, 4));      // Output: -1
        System.out.println(solver.shortestSubarray(new int[]{2, -1, 2}, 3));  // Output: 3
    }

}
