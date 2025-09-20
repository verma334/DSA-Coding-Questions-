package ArrayAndStringsDSAQuestions;

public class MissingNumberInArray {

	

    public static void main(String[] args) {
        // Example input: array missing one number from 1 to n
        int[] arr = {1, 2, 3, 5}; // Missing number is 3
        System.out.println(missingNum(arr));
    }

    // Method to find the missing number
    public static int missingNum(int[] arr) {
        // Step 1: Calculate n (total numbers including the missing one)
        int n = arr.length + 1;

        // Step 2: Use long to prevent overflow in large inputs
        long totalSum = (long) n * (n + 1) / 2;

        // Step 3: Sum the elements of the array
        long arraySum = 0;
        for (int num : arr) {
            arraySum += num;
        }

        // Step 4: Return the missing number as int
        return (int)(totalSum - arraySum);
    }
}
