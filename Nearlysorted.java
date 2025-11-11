package ArrayAndStringsDSAQuestions;

import java.util.PriorityQueue;

public class Nearlysorted {

	
	    public void nearlySorted(int[] arr, int k) {
	        // Min-heap to store k+1 elements
	        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	        int index = 0;

	        // Add first k+1 elements to the heap
	        for (int i = 0; i <= k && i < arr.length; i++) {
	            minHeap.add(arr[i]);
	        }

	        // Process remaining elements
	        for (int i = k + 1; i < arr.length; i++) {
	            arr[index++] = minHeap.poll();
	            minHeap.add(arr[i]);
	        }

	        // Extract remaining elements from the heap
	        while (!minHeap.isEmpty()) {
	            arr[index++] = minHeap.poll();
	        }
	    }
	public static void main(String[] args) {
		Nearlysorted ns = new Nearlysorted(); // Create object
        int[] arr = {2, 3, 1, 4};              // Input array
        int k = 2;                             // Max distance

        ns.nearlySorted(arr, k);              // Call the method

        // Print the sorted array
        System.out.print("Nearly sorted: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
		
		
	}
		

	

}
