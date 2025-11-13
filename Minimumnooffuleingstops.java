
package ArrayAndStringsDSAQuestions;
import java.util.PriorityQueue;

public class Minimumnooffuleingstops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int fuel = startFuel;
        int stops = 0;
        int i = 0;

        while (fuel < target) {
            // Add all reachable stations to the maxHeap
            while (i < stations.length && stations[i][0] <= fuel) {
                maxHeap.add(stations[i][1]);
                i++;
            }

            // If no station is available to refuel, return -1
            if (maxHeap.isEmpty()) return -1;

            // Refuel at the station with the maximum fuel
            fuel += maxHeap.poll();
            stops++;
        }

        return stops;
    }

    public static void main(String[] args) {
        Minimumnooffuleingstops obj = new Minimumnooffuleingstops();

        // Example test case 1
        int target1 = 100;
        int startFuel1 = 10;
        int[][] stations1 = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        System.out.println("Minimum stops (Test 1): " + obj.minRefuelStops(target1, startFuel1, stations1));
        // Expected output: 2

        // Example test case 2
        int target2 = 50;
        int startFuel2 = 25;
        int[][] stations2 = {{25, 25}};
        System.out.println("Minimum stops (Test 2): " + obj.minRefuelStops(target2, startFuel2, stations2));
        // Expected output: 1

        // Example test case 3
        int target3 = 100;
        int startFuel3 = 1;
        int[][] stations3 = {{10, 100}};
        System.out.println("Minimum stops (Test 3): " + obj.minRefuelStops(target3, startFuel3, stations3));
        // Expected output: -1
    }
}
