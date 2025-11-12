package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.List;

public class SkylineProblem {

	public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        
        // Step 1: Create events (start and end of buildings)
        for (int[] b : buildings) {
            int left = b[0], right = b[1], height = b[2];
            events.add(new int[]{left, -height}); // start event (negative height to distinguish)
            events.add(new int[]{right, height}); // end event (positive height)
        }
        
        // Step 2: Sort events
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // sort by x
            return a[1] - b[1]; // sort by height
        });
        
        // Step 3: Max-heap to store active heights
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.offer(0); // ground level
        int prevMax = 0;
        
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 4: Process events
        for (int[] e : events) {
            int x = e[0], h = e[1];
            
            if (h < 0) { // start of building
                heap.offer(-h);
            } else { // end of building
                heap.remove(h);
            }
            
            int currMax = heap.peek();
            if (currMax != prevMax) {
                result.add(Arrays.asList(x, currMax));
                prevMax = currMax;
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
	    SkylineProblem sl = new SkylineProblem();

	    // Correct 2D array initialization
	    int[][] buildings = {
	        {2, 9, 10},
	        {3, 7, 15},
	        {5, 12, 12},
	        {15, 20, 10},
	        {19, 24, 8}
	    };

	    // Assuming getSkyline returns a list of points
	    List<List<Integer>> result = sl.getSkyline(buildings);

	    // Print result
	    for (List<Integer> point : result) {
	        System.out.println(point);
	    }
	}

}
