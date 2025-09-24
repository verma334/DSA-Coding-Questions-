package ArrayAndStringsDSAQuestions;

public class MaximumCircularSubArraySum {


    // Kadane's algorithm to find max subarray sum
    public int kadaneMax(int[] arr) {
        int maxEndingHere = arr[0], maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    // Kadane's algorithm to find min subarray sum
    public int kadaneMin(int[] arr) {
        int minEndingHere = arr[0], minSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            minEndingHere = Math.min(arr[i], minEndingHere + arr[i]);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }
        return minSoFar;
    }

    // Main method to find max circular subarray sum
    public int maxCircularSum(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int maxKadane = kadaneMax(arr);
        int minKadane = kadaneMin(arr);

        // If all numbers are negative, return maxKadane
        if (maxKadane < 0) {
            return maxKadane;
        }

        // Return the maximum of non-wrapping and wrapping cases
        return Math.max(maxKadane, totalSum - minKadane);
    }


// Main method to test the solution
public static void main(String[] args) {
    int[] arr = {5, -2, 3, 4};
    MaximumCircularSubArraySum mc = new MaximumCircularSubArraySum();
    int result = mc.maxCircularSum(arr);
    System.out.println("Maximum circular subarray sum: " + result);
}
}
