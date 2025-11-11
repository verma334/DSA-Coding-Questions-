package ArrayAndStringsDSAQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class CostToHirekWorlders {

	public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double result = Double.MAX_VALUE;

        // Step 1: Create array of workers with [ratio, quality]
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i]; // wage-to-quality ratio
            workers[i][1] = quality[i];
        }

        // Step 2: Sort workers by ratio ascending
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));

        // Step 3: Use max heap to track k smallest qualities
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double qualitySum = 0;

        for (int i = 0; i < n; i++) {
            double ratio = workers[i][0];
            double q = workers[i][1];

            qualitySum += q;
            maxHeap.add(q);

            // Keep only k workers in the heap
            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }

            // If we have k workers, calculate the cost
            if (maxHeap.size() == k) {
                result = Math.min(result, ratio * qualitySum);
            }
        }

        return result;
    }
	public static void main(String[] args) {
	    CostToHirekWorlders solution = new CostToHirekWorlders();

	    int[] quality = {10, 20, 5};
	    int[] wage = {70, 50, 30};
	    int k = 2;

	    double minCost = solution.mincostToHireWorkers(quality, wage, k);
	    System.out.printf("Minimum cost to hire %d workers: %.2f\n", k, minCost);
	}

}
