package ArrayAndStringsDSAQuestions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Kclosestpointstoorigin {

    public int[][] kClosest(int[][] points, int k) {
        // Max-heap to store k closest points by distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> distance(b) - distance(a)
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the farthest point
            }
        }

        // Convert heap to result array
        int[][] result = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll();
        }

        return result;
    }

    // Helper to compute squared Euclidean distance from origin
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kclosestpointstoorigin km = new Kclosestpointstoorigin();
		int[][] points = { {1, 3}, {-2, 2} };
		int k = 1;
        int[][] result =km.kClosest(points,k);
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
	}

}
